import { useState } from 'react';
interface ModalHook {
  open: boolean;
  openModal: () => void;
  closeModal: () => void;
}
export default function useModal(): ModalHook {
  const [open, setOpen] = useState<boolean>(false);

  const openModal = (): void => setOpen(true);
  const closeModal = (): void => setOpen(false);

  return {
    open,
    openModal,
    closeModal,
  };
}
