import { useForm } from 'react-hook-form';
import { registerFormSchema, RegisterFormValues } from './validation';
import { zodResolver } from '@hookform/resolvers/zod';
import { TextField, Button, Snackbar, Alert } from '@mui/material';
import { registerUser } from './authService';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function RegisterForm() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<RegisterFormValues>({
    resolver: zodResolver(registerFormSchema),
  });

  const navigate = useNavigate();
  const [isLoading, setIsLoading] = useState<boolean>(false);
  const [alertMessage, setAlertMessage] = useState<string | null>(null);
  const [alertSeverity, setAlertSeverity] = useState<'success' | 'error'>(
    'success'
  );
  const [toastOpen, setToastOpen] = useState(false);

  const handleCloseToast = () => setToastOpen(false);

  const onSubmit = handleSubmit(async (data) => {
    setIsLoading(true);
    setAlertMessage(null);
    try {
      await registerUser(data);
      setAlertSeverity('success');
      setAlertMessage('Te has registrado con éxito. Serás redirigido al inicio de sesión.');
      setTimeout(() => {
        navigate('/login');
      }, 1000);
    } catch (error) {
      console.error('error--->', error);
      setAlertSeverity('error');
      if (
        error &&
        typeof error === 'object' &&
        'status' in error &&
        error.status === 409
      ) {
        setAlertMessage('El usuario ya está registrado');
      } else {
        setAlertMessage(
          'Ocurrió un error inesperado. Por favor, inténtalo de nuevo.'
        );
      }
    } finally {
      setIsLoading(false);
      setToastOpen(true);
    }
  });

  return (
    <form onSubmit={onSubmit}>
      <TextField
        label="Nombre"
        fullWidth
        {...register('firstName')}
        margin="normal"
        error={!!errors.firstName}
        helperText={errors.firstName?.message}
      />
      <TextField
        label="Apellido"
        fullWidth
        {...register('lastName')}
        margin="normal"
        error={!!errors.lastName}
        helperText={errors.lastName?.message}
      />
      <TextField
        label="Correo Electrónico"
        fullWidth
        {...register('email')}
        margin="normal"
        error={!!errors.email}
        helperText={errors.email?.message}
      />
      <TextField
        label="Contraseña"
        fullWidth
        type="password"
        {...register('password')}
        margin="normal"
        error={!!errors.password}
        helperText={errors.password?.message}
      />
      <TextField
        label="Confirmar Contraseña"
        fullWidth
        type="password"
        {...register('passwordConfirmation')}
        margin="normal"
        error={!!errors.passwordConfirmation}
        helperText={errors.passwordConfirmation?.message}
      />
      <Button
        type="submit"
        variant="contained"
        color="primary"
        fullWidth
        style={{ marginTop: 16 }}
        disabled={isLoading}
      >
        {isLoading ? 'Registrando...' : 'Registrarse'}
      </Button>

      {/* Toast */}
      <Snackbar
        open={toastOpen}
        autoHideDuration={4000}
        onClose={handleCloseToast}
        anchorOrigin={{ vertical: 'top', horizontal: 'center' }}
      >
        <Alert
          onClose={handleCloseToast}
          severity={alertSeverity}
          sx={{ width: '100%' }}
        >
          {alertMessage}
        </Alert>
      </Snackbar>
    </form>
  );
}
