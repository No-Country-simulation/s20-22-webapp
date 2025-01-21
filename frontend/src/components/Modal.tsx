import { Modal, Box, Typography, Button } from '@mui/material';

interface MyModalProps {
  open: boolean;
  closeModal: () => void;
  title: string;
  content: string;
}
export default function MyModal({
  open,
  closeModal,
  title,
  content,
}: MyModalProps) {
  return (
    <Modal
      open={open}
      onClose={closeModal}
      aria-labelledby="modal-title"
      aria-describedby="modal-description"
    >
      <Box
        sx={{
          position: 'absolute',
          top: '50%',
          left: '50%',
          transform: 'translate(-50%, -50%)',
          bgcolor: 'background.paper',
          borderRadius: 1,
          boxShadow: 24,
          p: 4,
          width: 300,
        }}
      >
        <Typography id="modal-title" variant="h6" component="h2">
          {title}
        </Typography>
        <Typography id="modal-description" sx={{ mt: 2 }}>
          {content}
        </Typography>
        <Button onClick={closeModal} sx={{ mt: 2 }}>
          Cerrar
        </Button>
      </Box>
    </Modal>
  );
}
