import { GoogleLogin } from '@react-oauth/google';
import { jwtDecode } from 'jwt-decode';
import { useAuth } from '../context/AuthContext';

const Inicio = () => {
  const { login, user } = useAuth();
  // Se o usuário já está logado, não mostra o botão
  if (user) {
    return (
      <div className="min-h-screen bg-gray-900 flex items-center justify-center text-white px-4">
        <div className="text-center">
          <h2 className="text-2xl font-bold">Você já está autenticado 😎</h2>
          <p className="text-gray-400 mt-2">Redirecione o usuário ou exiba outra informação aqui.</p>
        </div>
      </div>
    );
  }
  

  return (
    <div className="min-h-screen bg-gray-900 flex items-center justify-center text-white px-4">
      <div className="bg-gray-800 p-8 rounded-2xl shadow-lg text-center max-w-md w-full">
        <h1 className="text-3xl font-bold mb-4">Bem-vindo 👋</h1>
        <p className="text-gray-300 mb-6">Faça login com sua conta Google para continuar</p>

        <div className="flex justify-center">
          <GoogleLogin
            size="medium"
            width="250"
            onSuccess={(credentialResponse) => {
              const decoded = jwtDecode(credentialResponse.credential);
              console.log('Google user:', decoded);
              login(decoded);
            }}
            onError={() => {
              console.log('Login Failed');
            }}
          />
        </div>
      </div>
    </div>
  );
};

export default Inicio;
