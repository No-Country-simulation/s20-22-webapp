import { z } from 'zod';

export const registerFormSchema = z
  .object({
    email: z.string().email('El correo electrónico no es válido'),
    password: z
      .string()
      .min(8, 'La contraseña debe tener al menos 8 caracteres')
      .regex(
        /[A-Z]/,
        'La contraseña debe contener al menos una letra mayúscula'
      )
      .regex(/[0-9]/, 'La contraseña debe contener al menos un número'),
    passwordConfirmation: z
      .string()
      .min(
        8,
        'La confirmación de la contraseña debe tener al menos 8 caracteres'
      ),
    firstName: z.string().min(3, 'El nombre debe tener al menos 3 caracteres'),
    lastName: z.string().min(3, 'El apellido debe tener al menos 3 caracteres'),
  })
  .refine((data) => data.password === data.passwordConfirmation, {
    message: 'Las contraseñas no coinciden',
    path: ['passwordConfirmation'],
  });

export type RegisterFormValues = z.infer<typeof registerFormSchema>;
