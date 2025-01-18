import { cn } from '@/utils/cn.utill';
import { ReactNode, ButtonHTMLAttributes } from 'react';
import { cva, type VariantProps } from 'class-variance-authority';

// Definición de variantes extendidas
const buttonsVariant = cva(
  'inline-flex items-center justify-center rounded-md font-medium transition-colors focus:outline-none focus:ring-2 focus:ring-offset-2 disabled:opacity-50 disabled:cursor-not-allowed',
  {
    variants: {
      variant: {
        primary: 'bg-blue-500 text-white hover:bg-blue-600 focus:ring-blue-500',
        secondary:
          'bg-gray-500 text-white hover:bg-gray-600 focus:ring-gray-500',
        outline: 'border border-gray-300 text-gray-700 hover:bg-gray-100',
        danger: 'bg-red-500 text-white hover:bg-red-600 focus:ring-red-500',
        success:
          'bg-green-500 text-white hover:bg-green-600 focus:ring-green-500',
        warning:
          'bg-yellow-500 text-white hover:bg-yellow-600 focus:ring-yellow-500',
      },
      size: {
        sm: 'px-2.5 py-1.5 text-xs',
        md: 'px-3 py-2 text-sm',
        lg: 'px-4 py-2 text-base',
        xl: 'px-5 py-3 text-lg',
      },
      borderRadius: {
        none: 'rounded-none',
        sm: 'rounded-sm',
        md: 'rounded-md',
        lg: 'rounded-lg',
        full: 'rounded-full',
      },
      shadow: {
        none: 'shadow-none',
        sm: 'shadow-sm',
        md: 'shadow-md',
        lg: 'shadow-lg',
        xl: 'shadow-xl',
      },
      gap: {
        none: 'gap-0',
        sm: 'gap-1',
        md: 'gap-2',
        lg: 'gap-3',
      },
    },
    defaultVariants: {
      variant: 'primary',
      size: 'md',
      borderRadius: 'md',
      shadow: 'sm',
      gap: 'md',
    },
  }
);

interface ButtonProps
  extends ButtonHTMLAttributes<HTMLButtonElement>,
    VariantProps<typeof buttonsVariant> {
  children: ReactNode;
  isLoading?: boolean;
  icon?: ReactNode;
  loader?: ReactNode;
  iconPosition?: 'left' | 'right' | 'both';
  loadingPosition?: 'left' | 'right' | 'both';
  className?: string;
}

export const Button = ({
  children,
  variant,
  size,
  icon,
  loader,
  iconPosition = 'left',
  loadingPosition = 'right',
  isLoading,
  borderRadius,
  shadow,
  gap,
  className,
  ...props
}: ButtonProps) => {
  // Variables para determinar la visibilidad de los iconos y loaders
  const showIconLeft =
    !isLoading && (iconPosition === 'left' || iconPosition === 'both');
  const showIconRight =
    !isLoading && (iconPosition === 'right' || iconPosition === 'both');
  const showLoaderLeft =
    isLoading && (loadingPosition === 'left' || loadingPosition === 'both');
  const showLoaderRight =
    isLoading && (loadingPosition === 'right' || loadingPosition === 'both');

  return (
    <button
      className={cn(
        buttonsVariant({ variant, size, borderRadius, shadow, gap }),
        className
      )}
      disabled={isLoading || props.disabled}
      {...props}
    >
      {/* Renderizamos el loader o el icono según la posición y el estado de carga */}
      {showLoaderLeft && loader}
      {showIconLeft && icon}
      {children}
      {showIconRight && icon}
      {showLoaderRight && loader}
    </button>
  );
};
