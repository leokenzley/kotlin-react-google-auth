import { Routes, Route } from 'react-router-dom';
import Dashboard from './pages/Dashboard';
import PrivateRoute from './components/PrivateRoute';
import Layout from './components/Layout';
import Usuarios from './pages/Usuarios';
import Inicio from './pages/Inicio';


function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>

        <Route index element={<Inicio />} />
        <Route path="/dashboard" element={ <PrivateRoute>
              <Dashboard />
            </PrivateRoute>} />
            
        <Route path="/usuarios" element={ <PrivateRoute>
              <Usuarios />
            </PrivateRoute>} />
      </Route>
    </Routes>
  );
}

export default App;
