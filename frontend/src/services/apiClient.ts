// src/services/apiClient.ts
import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/artist', // ajuste conforme sua API
});

// Adicionar o token automaticamente em cada requisição
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('jwt');
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);


// ✅ REGISTRO DO INTERCEPTOR
api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      console.warn('🔐 Token expirado. Forçando logout...');
      localStorage.removeItem('jwt');
      localStorage.removeItem('user');
    }
    return Promise.reject(error);
  }
);
export default api;
