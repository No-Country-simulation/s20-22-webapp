import './App.css';
import AuthPage from './pages/AuthPage';
import RootLayout from './layouts';
import HomePage from './pages/HomePage';
import ErrorPage from './pages/ErrorPage';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';

const router = createBrowserRouter([
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
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
