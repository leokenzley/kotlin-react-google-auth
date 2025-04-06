// src/pages/UserCreate.tsx
import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import { userSchema } from "@/schemas/userSchema"; // Se você tiver configurado o alias `@` no Vite.
import { useAuth } from '@/context/AuthContext';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import { createUser } from '@/services/userService'; // Função para criar usuário
import PageContent from '@/components/PageContent';
import PageTitle from '@/components/PageTitle';
import { motion } from 'framer-motion'; // Importando o framer-motion
import UserForm from '../../components/users/forms/UserForm';




const UserCreate = () => {
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const handleCreateUser = async (data: UserInput) => {
    setLoading(true);
    try {
      await createUser(data);
      toast.success('Usuário criado com sucesso!');
      navigate('/users');
    } catch (error) {
      toast.error('Erro ao criar usuário.');
    } finally {
      setLoading(false);
    }
  };


  return (
    <PageContent>
      <PageTitle title="Criar Usuário" />
      <UserForm onSubmit={handleCreateUser} isLoading={loading} />
    </PageContent>
  );
};

export default UserCreate;
