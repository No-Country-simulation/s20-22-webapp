import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
import path from 'path';
const root = path.resolve(__dirname, './src');
// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: {
      '@': root,
      '@components': `${root}/components`,
      '@pages': `${root}/pages`,
      '@hooks': `${root}/hooks`,
      '@utils': `${root}/utils`,
      '@styles': `${root}/styles`,
      '@assets': `${root}/assets`,
      '@services': `${root}/services`,
    },
  },
});
