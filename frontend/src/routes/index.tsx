import RootLayout from '@/layouts';
import { ComponentsTest } from '@pages/Components.test';
import AuthPage from '@pages/AuthPage';
import ErrorPage from '@pages/ErrorPage';
import HomePage from '@pages/HomePage';
import RegisterPage from '@/pages/RegisterPage';
import { createBrowserRouter } from 'react-router-dom';

export const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    children: [
      {
        index: true,
        element: <HomePage />,
      },
      {
        path: 'auth',
        element: <AuthPage />,
      },
      {
        path: 'components',
        element: <ComponentsTest />,
      },
      { path: 'register', element: <RegisterPage /> },
    ],
  },
]);
