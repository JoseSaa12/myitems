function StatsPanel({ stats }) {
  return (
    <div className="border p-4 rounded mb-4 bg-gray-100">
      <h3 className="text-lg font-bold mb-2">Estadísticas</h3>
      <p>Total miembros: {stats.total}</p>
    </div>
  );
}

export default StatsPanel;
