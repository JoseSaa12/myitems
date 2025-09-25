function MemberModal({ isOpen, onClose, onSave, member, allTags }) {
  if (!isOpen) return null;

  const handleSubmit = (e) => {
    e.preventDefault();
    const form = new FormData(e.target);
    const data = {
      name: form.get("name"),
      description: form.get("description"),
    };
    onSave(data);
    onClose();
  };

  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
      <div className="bg-white p-6 rounded shadow-lg w-96">
        <h2 className="text-xl font-bold mb-4">
          {member ? "Editar Miembro" : "Nuevo Miembro"}
        </h2>
        <form onSubmit={handleSubmit} className="space-y-4">
          <div>
            <label className="block">Nombre</label>
            <input
              type="text"
              name="name"
              defaultValue={member?.name || ""}
              className="w-full border p-2 rounded"
            />
          </div>
          <div>
            <label className="block">Descripción</label>
            <textarea
              name="description"
              defaultValue={member?.description || ""}
              className="w-full border p-2 rounded"
            />
          </div>
          <div className="flex justify-end space-x-2">
            <button
              type="button"
              onClick={onClose}
              className="bg-gray-400 text-white px-4 py-2 rounded"
            >
              Cancelar
            </button>
            <button
              type="submit"
              className="bg-green-600 text-white px-4 py-2 rounded"
            >
              Guardar
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default MemberModal;
