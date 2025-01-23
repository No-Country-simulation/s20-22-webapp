export interface User {
  id: number;
  email: string;
  password: string;
  firstName: string;
  lastName: string;
}
export interface mockRegisterResponse {
  success: boolean;
  message: string;
  user?: Pick<User, 'firstName' | 'lastName'>;
}
const mockUsers: User[] = [
  {
    id: 1,
    email: 'juan.perez@example.com',
    password: 'Password123',
    firstName: 'Juan',
    lastName: 'Perez',
  },
  {
    id: 2,
    email: 'maria.gomez@example.com',
    password: '1234Password',
    firstName: 'Maria',
    lastName: 'Gomez',
  },
  {
    id: 3,
    email: 'luis.martinez@example.com',
    password: 'SecurePass456',
    firstName: 'Luis',
    lastName: 'Martinez',
  },
];

export const mockRegister = (user: Omit<User, 'id'>): mockRegisterResponse => {
  const existingUser = mockUsers.find((u) => u.email === user.email);
  if (existingUser) {
    throw {
      success: false,
      status: 409,
      message: 'El usuario ya está registrado',
      details: `El email ${user.email} ya está en uso.`,
    };
  }
  const newUser = { ...user, id: mockUsers.length + 1 };
  mockUsers.push(newUser);
  return {
    success: true,
    message: 'Usuario registrado correctamente',
    user: {
      firstName: newUser.firstName,
      lastName: newUser.lastName,
    },
  };
};

export const mockLogin = (email: string, password: string) => {
  const user = mockUsers.find(
    (user) => user.email === email && user.password === password
  );
  return user;
};
