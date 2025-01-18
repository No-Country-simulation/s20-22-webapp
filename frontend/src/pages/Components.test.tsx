import { Button } from '@/_ui/Button.ui';
import { Input } from '@/_ui/Input..ui';

export const ComponentsTest = () => {
  return (
    <>
      <Button
        icon={
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
            className="lucide lucide-chrome"
          >
            <circle cx="12" cy="12" r="10" />
            <circle cx="12" cy="12" r="4" />
            <line x1="21.17" x2="12" y1="8" y2="8" />
            <line x1="3.95" x2="8.54" y1="6.06" y2="14" />
            <line x1="10.88" x2="15.46" y1="21.94" y2="14" />
          </svg>
        }
      >
        CLICK
      </Button>
      <form action="">
      {/* Input de tipo password */}
      <Input
          type="password"
          placeholder="Enter your password"
          variant="secondary"
          inputSize="md"
        />
        
        {/* Input de tipo texto */}
        <Input
          type="text"
          placeholder="Enter your name"
          variant="primary"
          inputSize="lg"
        />
        
        {/* Input de tipo email */}
        <Input
          type="email"
          placeholder="Enter your email"
          variant="outline"
          inputSize="sm"
        />
        
        {/* Input deshabilitado */}
        <Input
          type="text"
          placeholder="Disabled input"
          variant="secondary"
          inputSize="md"
          disabled
        />
        
        {/* Input con valor predeterminado */}
        <Input
          type="text"
          placeholder="Enter your username"
          variant="primary"
          inputSize="md"
          defaultValue="defaultUser"
        />
        
        {/* Input con icono a la izquierda */}
        <Input
          type="text"
          placeholder="Input with left icon"
          variant="success"
          inputSize="md"
          icon={<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-person" viewBox="0 0 16 16"><path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/><path fillRule="evenodd" d="M8 9a5 5 0 0 0-4.546 2.916C3.02 12.68 3 13.318 3 14v1h10v-1c0-.682-.02-1.32-.454-1.084A5 5 0 0 0 8 9z"/></svg>}
          iconPosition="left"
        />
        
        {/* Input con icono a la derecha */}
        <Input
          type="text"
          placeholder="Input with right icon"
          variant="danger"
          inputSize="md"
          icon={<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-lock" viewBox="0 0 16 16"><path d="M8 1a3 3 0 0 0-3 3v3H4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2v-5a2 2 0 0 0-2-2h-1V4a3 3 0 0 0-3-3zM5 4a3 3 0 0 1 6 0v3H5V4zm-1 5h8a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1v-5a1 1 0 0 1 1-1z"/></svg>}
          iconPosition="right"
        />
        
        {/* Input con error */}
        <Input
          type="text"
          placeholder="Input with error"
          variant="outline"
          inputSize="md"
          error="This field is required"
        />
        
        {/* Input con loader */}
        <Input
          type="text"
          placeholder="Input with loader"
          variant="primary"
          inputSize="md"
          isLoading
          loader={<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-arrow-repeat animate-spin" viewBox="0 0 16 16"><path d="M11.534 7h-1.69a.5.5 0 0 0 0 1h1.69a.5.5 0 0 0 0-1z"/><path d="M8 3a5 5 0 0 1 4.546 2.916c.434.764.454 1.402.454 2.084v1h-1v-1c0-.682-.02-1.32-.454-1.084A5 5 0 0 0 8 3z"/><path fillRule="evenodd" d="M8 1a7 7 0 0 0-6.546 4.916C1.02 6.68 1 7.318 1 8v1h1V8c0-.682.02-1.32.454-1.084A7 7 0 0 1 8 1z"/></svg>}
        />
      </form>
    </>
  );
};
