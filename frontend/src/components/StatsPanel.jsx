// frontend/src/components/StatsPanel.jsx
function StatsPanel({ stats }) {
  if (!stats) return null;

  return (
    <div className="bg-gray-800 text-white p-4 rounded">
      <h3 className="text-lg font-bold mb-2">📊 Estadísticas</h3>
      <ul>
        <li>Total miembros: {stats.totalMembers}</li>
        <li>Activos: {stats.activeMembers}</li>
        <li>Inactivos: {stats.inactiveMembers}</li>
      </ul>
    </div>
  );
}

export default StatsPanel;
