import GymDashboard from "./components/GymDashboard";

function App() {
  return (
    <div className="min-h-screen bg-gray-50">
      <header className="bg-blue-600 text-white p-4 shadow">
        <h1 className="text-2xl font-bold text-center">MyItems Frontend</h1>
      </header>
      <main className="p-6">
        <GymDashboard />
      </main>
    </div>
  );
}

export default App;
