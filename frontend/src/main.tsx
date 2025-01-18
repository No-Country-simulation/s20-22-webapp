import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import './styles/tailwind.css';
import App from './App.tsx';
import { ComponentsTest } from './pages/Components.test.tsx';

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <App />
    <ComponentsTest />
  </StrictMode>
);
