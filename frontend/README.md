# Aplicação React + TypeScript + Vite

Este projeto é uma aplicação web desenvolvida utilizando as seguintes tecnologias e ferramentas:

## Tecnologias Utilizadas

- **[React](https://reactjs.org/):** Biblioteca JavaScript para construção de interfaces de usuário.
- **[TypeScript](https://www.typescriptlang.org/):** Superset do JavaScript que adiciona tipagem estática ao código.
- **[Vite](https://vitejs.dev/):** Ferramenta de build rápida para desenvolvimento web moderno.
- **[Tailwind CSS](https://tailwindcss.com/):** Framework CSS utilitário para estilização rápida e eficiente.
- **[Bootstrap](https://getbootstrap.com/):** Biblioteca de componentes CSS para design responsivo.
- **[React Router](https://reactrouter.com/):** Biblioteca para gerenciamento de rotas no React.
- **[Lucide React](https://lucide.dev/):** Conjunto de ícones otimizados para React.
- **[Google OAuth](https://www.npmjs.com/package/@react-oauth/google):** Integração para autenticação com contas Google.
- **[JWT Decode](https://www.npmjs.com/package/jwt-decode):** Biblioteca para decodificação de tokens JWT.

## Estrutura do Projeto

A estrutura do projeto está organizada da seguinte forma:

- **`src/components`:** Componentes reutilizáveis, como `Topbar`, `Navbar`, `Layout` e `PrivateRoute`.
- **`src/pages`:** Páginas principais da aplicação, como `Inicio`, `Dashboard`, `Usuarios` e `Conta`.
- **`src/context`:** Contexto de autenticação utilizando o React Context API.
- **`src/assets`:** Recursos estáticos, como imagens e ícones.
- **`src/index.css` e `src/App.css`:** Arquivos de estilo base utilizando Tailwind CSS.

## Configuração do Ambiente

- **Tailwind CSS:** Configurado nos arquivos `tailwind.config.ts` e `src/index.css`.
- **ESLint:** Configuração personalizada no arquivo `eslint.config.js` para garantir boas práticas de código.
- **TypeScript:** Configurações detalhadas nos arquivos `tsconfig.json`, `tsconfig.app.json` e `tsconfig.node.json`.

## Scripts Disponíveis

Os scripts podem ser executados utilizando o gerenciador de pacotes `npm`:

- `npm run dev`: Inicia o servidor de desenvolvimento.
- `npm run build`: Realiza o build da aplicação para produção.
- `npm run lint`: Executa o ESLint para verificar problemas no código.
- `npm run preview`: Inicia um servidor para pré-visualizar o build de produção.

## Autenticação com Google OAuth

A aplicação utiliza o **Google OAuth** para autenticação. Para configurar:

1. Crie um projeto no [Google Cloud Console](https://console.cloud.google.com/).
2. Ative a API de autenticação OAuth 2.0.
3. Gere um **Client ID** e configure os redirecionamentos autorizados.
4. No arquivo `src/main.tsx`, configure o `GoogleOAuthProvider` com o `clientId` gerado:
   ```tsx
   import { GoogleOAuthProvider } from '@react-oauth/google';

   const clientId = 'SEU_CLIENT_ID_AQUI';

   ReactDOM.createRoot(document.getElementById('root')!).render(
     <GoogleOAuthProvider clientId={clientId}>
       <App />
     </GoogleOAuthProvider>
   );

## Como Executar

1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd lkwebapp

