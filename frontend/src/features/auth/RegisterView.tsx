import { Container } from '@mui/material';
import RegisterForm from './RegisterForm';

export default function RegisterView() {
  return (
    <Container maxWidth="sm" sx={{ mt: 4 }}>
      <RegisterForm />
    </Container>
  );
}
