// src/pages/UserCreate.tsx
import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import { userSchema } from "@/schemas/userSchema"; // Se você tiver configurado o alias `@` no Vite.
import { useAuth } from '@/context/AuthContext';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import { createUser } from '@/services/userService'; // Função para criar usuário

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
    <div className="max-w-4xl mx-auto p-6 bg-gray-800 text-gray-100 rounded-lg">
      <h1 className="text-3xl font-bold mb-6">Criar Usuário</h1>
      <form onSubmit={handleSubmit(onSubmit)} className="space-y-6">
        <div>
          <label className="block text-lg" htmlFor="name">Nome</label>
          <input
            type="text"
            id="name"
            {...register('name')}
            className="w-full p-3 bg-gray-700 text-white border border-gray-600 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
          {errors.name && <p className="text-red-500 text-sm">{errors.name.message}</p>}
        </div>

        <div>
          <label className="block text-lg" htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            {...register('email')}
            className="w-full p-3 bg-gray-700 text-white border border-gray-600 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
          {errors.email && <p className="text-red-500 text-sm">{errors.email.message}</p>}
        </div>

        <button
          type="submit"
          disabled={loading}
          className="w-full p-3 bg-blue-600 text-white rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
        >
          {loading ? 'Criando...' : 'Criar Usuário'}
        </button>
      </form>
    </div>
  );
};

export default UserCreate;
