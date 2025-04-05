import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css';
import App from './App.tsx'
import 'bootstrap/dist/css/bootstrap.min.css';
import { AuthProvider } from './context/AuthContext.tsx'
import { GoogleOAuthProvider } from '@react-oauth/google'
import { BrowserRouter } from 'react-router-dom';
const clientId = import.meta.env.VITE_GOOGLE_CLIENT_ID;
createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <GoogleOAuthProvider clientId={clientId}>
      <AuthProvider>
        <BrowserRouter>
          <App />
        </BrowserRouter>
      </AuthProvider>
    </GoogleOAuthProvider>
  </StrictMode>
)
