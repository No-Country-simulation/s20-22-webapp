import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function AuthPage() {
  // Esta página cambiará eventualmente, de momento queda así para tener una base sobre la cual construir.
  // No se puede avanzar más con la autenticación dado que se necesita de los backend para el JWT.

  const [isLogin, setIsLogin] = useState(false);

  const navigate = useNavigate();

  const toggleAuthMode = () => {
    setIsLogin((prev) => !prev);
  };

  const goToMainPage = (e) => {
    e.preventDefault();
    navigate('/');
  };

  return (
    <div>
      <div>
        <h1>{isLogin ? 'Iniciar Sesión' : 'Crear Cuenta'}</h1>

        {isLogin ? (
          <form onSubmit={goToMainPage}>
            <input type="email" placeholder="Correo electrónico" required />
            <input type="password" placeholder="Contraseña" required />
            <button type="submit">Iniciar Sesión</button>
          </form>
        ) : (
          <form onSubmit={goToMainPage}>
            <input type="text" placeholder="Nombre de usuario" required />
            <input type="email" placeholder="Correo electrónico" required />
            <input type="password" placeholder="Contraseña" required />
            <button type="submit">Crear Cuenta</button>
          </form>
        )}
        <p>
          {isLogin ? '¿No tienes una cuenta? ' : '¿Ya tienes una cuenta? '}
          <span
            onClick={toggleAuthMode}
            style={{ cursor: 'pointer', color: 'blue' }}
          >
            {isLogin ? 'Regístrate aquí' : 'Inicia sesión'}
          </span>
        </p>
      </div>
    </div>
  );
}
