import { cn } from '@/utils/cn.utill';
import { InputHTMLAttributes, ReactNode } from 'react';
import { cva, type VariantProps } from 'class-variance-authority';

// Definición de variantes
const inputVariant = cva(
  'block w-full rounded-md border transition-colors focus:outline-none focus:ring-2 focus:ring-offset-2',
  {
    variants: {
      variant: {
        primary: 'bg-white text-gray-900 border-gray-300 focus:ring-blue-500',
        secondary:
          'bg-gray-100 text-gray-800 border-gray-400 focus:ring-gray-500',
        outline:
          'bg-transparent text-gray-700 border-gray-300 focus:ring-blue-500',
        danger: 'bg-red-50 text-red-500 border-red-300 focus:ring-red-500',
        success:
          'bg-green-50 text-green-500 border-green-300 focus:ring-green-500',
      },
      inputSize: {
        sm: 'px-2.5 py-1.5 text-xs',
        md: 'px-3 py-2 text-sm',
        lg: 'px-4 py-2 text-base',
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
      },
    },
    defaultVariants: {
      variant: 'primary',
      inputSize: 'md',
      borderRadius: 'md',
      shadow: 'sm',
    },
  }
);

interface InputProps
  extends InputHTMLAttributes<HTMLInputElement>,
    VariantProps<typeof inputVariant> {
  error?: string;
  icon?: ReactNode;
  iconPosition?: 'left' | 'right';
  isLoading?: boolean;
  loader?: ReactNode;
  className?: string;
}

export const Input = ({
  error,
  icon,
  iconPosition = 'left',
  inputSize,
  variant,
  borderRadius,
  shadow,
  isLoading,
  loader,
  className,
  disabled,
  ...props
}: InputProps) => {
  const isDisabled = isLoading || disabled;

  const inputClass = cn(
    inputVariant({ variant, inputSize, borderRadius, shadow }),
    className,
    isDisabled && 'opacity-50 cursor-not-allowed',
    error ? 'border-red-500' : 'border-gray-300',
    icon && iconPosition === 'left' && 'pl-10',
    icon && iconPosition === 'right' && 'pr-10'
  );

  const iconClass = 'absolute top-1/2 transform -translate-y-1/2 text-gray-400';

  return (
    <div className={cn('relative', className)}>
      {icon && iconPosition === 'left' && (
        <div className={cn(iconClass, 'left-3')}>{icon}</div>
      )}
      <input {...props} className={inputClass} disabled={isDisabled} />
      {icon && iconPosition === 'right' && (
        <div className={cn(iconClass, 'right-3')}>{icon}</div>
      )}
      {isLoading && loader && (
        <div className={cn(iconClass, 'right-3')}>{loader}</div>
      )}
      {error && <span className="mt-1 text-xs text-red-500">{error}</span>}
    </div>
  );
};
