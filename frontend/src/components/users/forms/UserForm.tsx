import React, { useState, useEffect } from 'react';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import { userSchema } from '@/schemas/userSchema';
import { motion } from 'framer-motion';

interface UserFormProps {
  initialData?: UserInput; // Dados iniciais para edição (opcional)
  onSubmit: (data: UserInput) => Promise<void>; // Função de submissão
  isLoading?: boolean; // Estado de carregamento
}

const UserForm: React.FC<UserFormProps> = ({ initialData, onSubmit, isLoading = false }) => {
  const { register, handleSubmit, formState: { errors }, reset } = useForm<UserInput>({
    resolver: zodResolver(userSchema),
    defaultValues: initialData, // Preenche o formulário com os dados iniciais, se fornecidos
  });

  const handleFormSubmit = async (data: UserInput) => {
    await onSubmit(data);
    reset(); // Limpa o formulário após a submissão
  };

    // Atualiza os valores do formulário quando `initialData` mudar
    useEffect(() => {
      if (initialData) {
        reset(initialData); // Atualiza os valores do formulário
      }
    }, [initialData, reset]);

  return (
    <motion.form
      onSubmit={handleSubmit(handleFormSubmit)}
      className="space-y-6"
      initial={{ opacity: 0, x: -50 }}
      animate={{ opacity: 1, x: 0 }}
      transition={{ duration: 0.5 }}
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
        disabled={isLoading}
        className="w-full p-2 bg-blue-600 text-white rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
      >
        {isLoading ? 'Salvando...' : 'Salvar'}
      </button>
    </motion.form>
  );
};

export default UserForm;