import { Routes, Route } from 'react-router-dom';
import Dashboard from './pages/Dashboard';
import PrivateRoute from './components/PrivateRoute';
import Layout from './components/Layout';
import Usuarios from './pages/Usuarios';
import Inicio from './pages/Inicio';
import UserList from '@/pages/users/UserList'
import UserCreate from './pages/users/UserCreate';


function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>

        <Route index element={<Inicio />} />
        <Route path="/dashboard" element={ <PrivateRoute>
              <Dashboard />
            </PrivateRoute>} />
            
        <Route path="/usuarios" element={ <PrivateRoute>
              <UserList />
            </PrivateRoute>} />
            <Route path="/users/create" element={<PrivateRoute><UserCreate /></PrivateRoute>} />
      </Route>
    </Routes>
  );
}

export default App;
