import { useAuth } from '../context/AuthContext';

function Topbar() {
  const { user, logout } = useAuth();

  return (
    <div className="flex items-center justify-between bg-gray-800 px-6 py-4 shadow-md">
      <div className="text-xl font-bold text-white"></div>
      {user && (
        <div className="flex items-center gap-4">
          <span className="text-white">{user.name}</span>
          <img
            src={user.picture}
            alt={user.name}
            className="w-10 h-10 rounded-full border border-white"
          />
          <button
            onClick={logout}
            className="bg-red-600 hover:bg-red-700 text-white text-sm px-4 py-2 rounded"
          >
            Logout
          </button>
        </div>
      )}
    </div>
  );
}

export default Topbar;
