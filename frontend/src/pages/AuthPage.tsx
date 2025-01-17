import { useState } from 'react';

export default function AuthPage() {
  const [isLogin, setIsLogin] = useState(false);

  const toggleAuthMode = () => {
    setIsLogin((prev) => !prev);
  };

  return (
    <div>
      <div>
        <h1>{isLogin ? 'Iniciar Sesión' : 'Crear Cuenta'}</h1>

        {isLogin ? (
          <form>
            <input type="email" placeholder="Correo electrónico" required />
            <input type="password" placeholder="Contraseña" required />
            <button type="submit">Iniciar Sesión</button>
          </form>
        ) : (
          <form>
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
