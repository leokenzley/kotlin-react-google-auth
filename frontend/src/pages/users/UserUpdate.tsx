// src/pages/UserUpdate.tsx
import React, { useState, useEffect } from 'react';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import { userSchema } from "@/schemas/userSchema"; // Se você tiver configurado o alias `@` no Vite.
import { useAuth } from '@/context/AuthContext';
import { useNavigate, useParams} from 'react-router-dom';
import { toast } from 'react-toastify';
import { updateUser, getUserById } from '@/services/userService'; // Função para criar usuário
import PageContent from '@/components/PageContent';
import PageTitle from '@/components/PageTitle';
import { motion } from 'framer-motion'; // Importando o framer-motion
import UserForm from '../../components/users/forms/UserForm';


const UserUpdate = () => {
    const { id } = useParams<{ id: string }>(); // Obtém o ID do parâmetro da URL=
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();
    const [userFindById, setUserFindById] = useState<UserInput | null>(null); // Estado para armazenar os dados do usuário
  
    const handleUpdateUser = async (data: UserInput) => {
      setLoading(true);
      try {
        await updateUser(data, id);
        toast.success('Usuário criado com sucesso!');
        navigate('/users');
      } catch (error) {
        toast.error('Erro ao criar usuário.');
      } finally {
        setLoading(false);
      }
    };

    useEffect(() => {
        const fetchUser = async () => {
          try {
            const user = await getUserById(id!); // Busca os dados do usuário pelo ID
            setUserFindById(user); // Armazena os dados no estado
          } catch (error) {
            console.error('Error fetching user:', error);
            toast.error('Erro ao buscar usuário.');
            navigate('/users'); // Redireciona para a lista de usuários em caso de erro
          }
        };
      
        if (id && !userFindById) {
          fetchUser(); // Chama a função apenas se o ID estiver definido e os dados ainda não foram carregados
        }
      }, [id]); // Remove `navigate

  
    return (
      <PageContent>
        <PageTitle title="Edit User" />
        <UserForm onSubmit={handleUpdateUser} isLoading={loading} initialData={userFindById}/>
      </PageContent>
    );
  };

  export default UserUpdate;
