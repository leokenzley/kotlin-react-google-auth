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




const UserCreate = () => {
  const { register, handleSubmit, formState: { errors }, reset } = useForm<UserInput>({
    resolver: zodResolver(userSchema),
  });

  const [loading, setLoading] = useState(false);
  const { user } = useAuth();
  const navigate = useNavigate();
  

  const onSubmit = async (data: UserInput) => {
    setLoading(true);
    try {
      // Chamada para criar usuário via serviço
      await createUser(data);
      
      // Mostrar toast de sucesso
      toast.success('Usuário criado com sucesso!');

      // Limpar os campos do formulário
      reset();

      // Redirecionar para a página de usuários
      navigate('/usuarios');
    } catch (error) {
      toast.error('Erro ao criar usuário.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <PageContent>
        <PageTitle title="Criar Usuário" />
        <motion.form
        onSubmit={handleSubmit(onSubmit)}
        className="space-y-6"
        initial={{ opacity: 0, x: -50 }} // Começa invisível e deslocado para a esquerda
        animate={{ opacity: 1, x: 0 }} // Fica visível e se move para a posição original
        transition={{ duration: 0.5 }} // Duração da animação
      >
        <div>
          <label className="block text-lg" htmlFor="name">Nome</label>
          <input
            type="text"
            id="name"
            {...register('name')}
            className="w-full p-2 bg-gray-700 text-white border border-gray-600 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
          {errors.name && <p className="text-red-500 text-sm">{errors.name.message}</p>}
        </div>

        <div>
          <label className="block text-lg" htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            {...register('email')}
            className="w-full p-2 bg-gray-700 text-white border border-gray-600 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
          {errors.email && <p className="text-red-500 text-sm">{errors.email.message}</p>}
        </div>

        <button
          type="submit"
          disabled={loading}
          className="w-full p-2 bg-blue-600 text-white rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
        >
          {loading ? 'Criando...' : 'Criar Usuário'}
        </button>
        </motion.form>
      </PageContent>
  );
};

export default UserCreate;
