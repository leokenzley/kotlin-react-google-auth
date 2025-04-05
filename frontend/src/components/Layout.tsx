import { Link, Outlet, useLocation } from 'react-router-dom';
import Topbar from '../components/Topbar';
import { Home as HomeIcon, LayoutDashboard as DashboardIcon, Users as UsersIcon } from 'lucide-react';
import { useAuth } from '../context/AuthContext';

function Layout() {
  const location = useLocation();
  const { user } = useAuth();
  const linkClass = (path: string) =>
    `flex items-center space-x-2 px-3 py-2 rounded-md hover:bg-gray-700 ${location.pathname === path ? 'bg-gray-700' : ''
    }`;

  return (
    <div className="min-h-screen flex bg-gray-900 text-white">
      {/* Sidebar */}
      {user && (
      <aside className="w-64 bg-gray-800 p-6">
        <h2 className="text-2xl font-bold mb-6">Menu</h2>
        <nav className="flex flex-col space-y-4">
          <Link to="/" className={linkClass('/')}>
            <HomeIcon className="w-5 h-5" />
            <span>Home</span>
          </Link>
          <Link to="/dashboard" className={linkClass('/dashboard')}>
            <DashboardIcon className="w-5 h-5" />
            <span>Dashboard</span>
          </Link>
          <Link to="/usuarios" className={linkClass('/usuarios')}>
            <UsersIcon className="w-5 h-5" />
            <span>Usuários</span>
          </Link>
        </nav>
      </aside>
       )}
      {/* Sidebar END*/}
      {/* Main area */}
      <div className="flex-1 flex flex-col min-h-screen dark:bg-gray-900 text-gray-900 dark:text-gray-100">
        <Topbar />
        <main className="min-h-screen dark:bg-gray-900 text-gray-900 dark:text-gray-100 p-6">
          <Outlet />
        </main>
      </div>
    </div>
  );
}

export default Layout;
