import { useState, useEffect } from "react";
import { Plus, BarChart3 } from "lucide-react";
import { getPaged } from "../api/accountHolders/accountHolders";
import MemberList from "./MemberList";
import MemberModal from "./MemberModal";
import StatsPanel from "./StatsPanel";

function GymDashboard() {
  const [members, setMembers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [editingMember, setEditingMember] = useState(null);
  const [showStats, setShowStats] = useState(false);

  // 🔥 Cargar desde backend
  useEffect(() => {
    getPaged(0, 10, "id", "ASC").then((res) => {
      setMembers(res.data);
      setLoading(false);
    });
  }, []);

  const handleEditMember = (member) => {
    setEditingMember(member);
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
    setEditingMember(null);
  };

  const handleSaveMember = (memberData) => {
    console.log("Guardar miembro:", memberData);
  };

  const handleDeleteMember = (id) => {
    console.log("Eliminar miembro:", id);
  };

  const handleToggleStatus = (id) => {
    console.log("Cambiar estado del miembro:", id);
  };

  if (loading) return <p>Cargando...</p>;

  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold mb-4">Gym Dashboard</h1>

      <button
        onClick={() => setIsModalOpen(true)}
        className="bg-blue-500 text-white px-4 py-2 rounded mb-4"
      >
        <Plus className="inline h-4 w-4 mr-2" />
        Nuevo Miembro
      </button>

      <button
        onClick={() => setShowStats(!showStats)}
        className="ml-4 bg-gray-200 px-4 py-2 rounded"
      >
        <BarChart3 className="inline h-4 w-4 mr-2" />
        {showStats ? "Ocultar Stats" : "Ver Stats"}
      </button>

      {showStats && <StatsPanel stats={{ total: members.length }} />}

      <MemberList
        members={members}
        onEdit={handleEditMember}
        onDelete={handleDeleteMember}
        onToggleStatus={handleToggleStatus}
      />

      <MemberModal
        isOpen={isModalOpen}
        onClose={handleCloseModal}
        onSave={handleSaveMember}
        member={editingMember}
        allTags={["MMA", "Boxeo", "Crossfit"]}
      />
    </div>
  );
}

export default GymDashboard;
