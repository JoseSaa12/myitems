// frontend/src/components/GymDashboard.jsx
import { useState } from "react";
import { Plus, BarChart3 } from "lucide-react";
import MemberList from "./MemberList";
import MemberModal from "./MemberModal";
import StatsPanel from "./StatsPanel";
import { useGymMembers } from "../hooks/useGymMembers";

function GymDashboard() {
  const {
    members,
    loading,
    stats,
    addMember,
    updateMember,
    deleteMember,
    toggleMemberStatus,
  } = useGymMembers();

  const [isModalOpen, setIsModalOpen] = useState(false);
  const [editingMember, setEditingMember] = useState(null);
  const [showStats, setShowStats] = useState(true);

  const handleAddMember = () => {
    setEditingMember(null);
    setIsModalOpen(true);
  };

  const handleSaveMember = async (data) => {
    if (editingMember) {
      await updateMember(editingMember.id, data);
    } else {
      await addMember(data);
    }
    setIsModalOpen(false);
  };

  const handleEditMember = (member) => {
    setEditingMember(member);
    setIsModalOpen(true);
  };

  return (
    <div className="p-4">
      <h1 className="text-3xl font-bold mb-4">MyItems Frontend</h1>
      <h2 className="text-2xl font-bold mb-4">Gym Members</h2>

      <div className="flex space-x-2 mb-4">
        <button
          onClick={() => setShowStats(!showStats)}
          className="bg-gray-800 text-white px-4 py-2 rounded flex items-center"
        >
          <BarChart3 className="mr-2" size={16} />
          {showStats ? "Ocultar Stats" : "Stats"}
        </button>
        <button
          onClick={handleAddMember}
          className="bg-black text-white px-4 py-2 rounded flex items-center"
        >
          <Plus className="mr-2" size={16} /> Add Member
        </button>
      </div>

      {showStats && <StatsPanel stats={stats} />}

      {loading ? (
        <p>Cargando miembros...</p>
      ) : (
        <MemberList
          members={members}
          onEdit={handleEditMember}
          onDelete={deleteMember}
          onToggleStatus={toggleMemberStatus}
        />
      )}

      <MemberModal
        isOpen={isModalOpen}
        onClose={() => setIsModalOpen(false)}
        onSave={handleSaveMember}
        member={editingMember}
      />
    </div>
  );
}

export default GymDashboard;
