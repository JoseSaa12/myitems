// frontend/src/components/MemberList.jsx
function MemberList({ members, onEdit, onDelete, onToggleStatus }) {
  if (!members || members.length === 0) {
    return <p>No hay miembros que mostrar</p>;
  }

  return (
    <ul className="space-y-2">
      {members.map((member) => (
        <li
          key={member.id}
          className="flex justify-between items-center border p-2 rounded"
        >
          <div>
            <b>{member.name}</b> - {member.description || "Sin descripción"}
          </div>
          <div className="space-x-2">
            <button
              onClick={() => onEdit(member)}
              className="bg-yellow-500 text-white px-2 py-1 rounded"
            >
              Editar
            </button>
            <button
              onClick={() => onToggleStatus(member.id)}
              className="bg-blue-500 text-white px-2 py-1 rounded"
            >
              Estado
            </button>
            <button
              onClick={() => onDelete(member.id)}
              className="bg-red-500 text-white px-2 py-1 rounded"
            >
              Eliminar
            </button>
          </div>
        </li>
      ))}
    </ul>
  );
}

export default MemberList;
