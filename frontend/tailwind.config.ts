import type { Config } from 'tailwindcss';

const config: Config = {
  content: [
    './index.html',
    './src/**/*.{js,ts,jsx,tsx}',
  ],
  darkMode: 'class', // ou 'media' se preferir automático
  theme: {
    extend: {},
  },
  plugins: [],
};

export default config;
