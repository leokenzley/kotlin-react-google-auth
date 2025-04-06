// src/services/userService.ts
import { PaginatedResponse } from '../types/PaginatedResponse';
import { UserFormData } from '@/schemas/userSchema';
import api from './apiClient';

export interface User {
  id: string;
  name: string;
  email: string;
}

export const getPaginatedUsers = async (
  page = 0,
  size = 10,
  sort = 'name,DESC'
): Promise<PaginatedResponse<User>> => {
  const response = await api.get<PaginatedResponse<User>>('/users/paginated', {
    params: { page, size, sort },
  });
  return response.data;
};



export const createUser = async (userData: { name: string, email: string }) => {
  try {
    const token = localStorage.getItem('jwt');
    const response = await api.post('/users', userData, {});
    return response.data;
  } catch (error) {
    console.error("Error creating user:", error);
    throw error; // Ou retornar algum tipo de mensagem de erro
  }
};


export const getUserById = async (id: string) => {
  const response = await api.get(`/users/${id}`, {});
  return response.data; // Retorna os dados do usuário
};

export const updateUser = async (userData: UserFormData, id: string) => {
  const response = await api.put(`/users/${id}`, userData, {});
  return response.data;
}