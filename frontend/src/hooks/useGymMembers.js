// frontend/src/hooks/useGymMembers.js
import { useEffect, useMemo, useState } from "react";
import { listPaged, createOne, updateOne, removeOne } from "../api/accountHolders/accountHolders";

export function useGymMembers() {
  const [members, setMembers] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedTags, setSelectedTags] = useState([]);
  const [loading, setLoading] = useState(true);

  async function load() {
    try {
      setLoading(true);
      // Leemos directamente un array gracias a listPaged()
      const items = await listPaged({ page: 0, size: 100, sortBy: "id", direction: "ASC" });
      setMembers(items);
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    load();
  }, []);

  const filtered = useMemo(() => {
    const term = searchTerm.trim().toLowerCase();
    let arr = members;

    if (term) {
      arr = arr.filter(
        (m) =>
          (m.name || "").toLowerCase().includes(term) ||
          (m.description || "").toLowerCase().includes(term)
      );
    }
    if (selectedTags.length) {
      arr = arr.filter((m) => (m.tags || []).some((t) => selectedTags.includes(t)));
    }
    return arr;
  }, [members, searchTerm, selectedTags]);

  const stats = useMemo(
    () => ({
      totalMembers: members.length,
      activeMembers: members.filter((m) => m.status === "active").length,
      inactiveMembers: members.filter((m) => m.status !== "active").length,
    }),
    [members]
  );

  const allTags = useMemo(() => {
    const s = new Set();
    members.forEach((m) => (m.tags || []).forEach((t) => s.add(t)));
    return Array.from(s);
  }, [members]);

  async function addMember(data) {
    await createOne({ name: data.name, description: data.description });
    await load();
  }

  async function updateMember(id, data) {
    await updateOne(id, { name: data.name, description: data.description });
    await load();
  }

  async function deleteMember(id) {
    await removeOne(id);
    setMembers((prev) => prev.filter((m) => m.id !== id));
  }

  function toggleMemberStatus(id) {
    // Solo UI: NO tocamos backend.
    setMembers((prev) =>
      prev.map((m) =>
        m.id === id ? { ...m, status: m.status === "active" ? "inactive" : "active" } : m
      )
    );
  }

  return {
    members: filtered,
    loading,
    searchTerm,
    setSearchTerm,
    selectedTags,
    setSelectedTags,
    stats,
    allTags,
    addMember,
    updateMember,
    deleteMember,
    toggleMemberStatus,
  };
}
