// tailwind.config.ts
import type { Config } from 'tailwindcss'

const config: Config = {
  content: [
    './index.html',
    './src/**/*.{js,ts,jsx,tsx}', // escaneia todos os arquivos que podem ter classes
  ],
  darkMode: 'class', // permite ativar dark mode via classe
  theme: {
    extend: {},
  },
  plugins: [],
}

export default config
