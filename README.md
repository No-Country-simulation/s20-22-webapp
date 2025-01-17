# s20-22-webapp

# FRONTEND

# Estructura del proyecto

Este proyecto esta diseñado para gestionar eventos

```plaintext
src/
├── _ui/                # Carpetas para componentes básicos de la UI (por ejemplo, botones, inputs, modales)
├── components/        # Carpetas para componentes específicos de la aplicación (por ejemplo, Navbar, Sidebar)
├── features/          # Carpetas para funcionalidades específicas (por ejemplo, eventos, usuarios)
├── hooks/             # Carpeta para custom hooks globales
├── layouts/           # Plantillas de diseño globales
├── mocks/             # Datos simulados para desarrollo o pruebas 
├── pages/             # Páginas principales de la aplicación
├── routes/            # Configuración de rutas
├── services/          # Lógica de negocio y servicios de APIs
├── state/             # Estado global (Zustand)
├── styles/            # Estilos globales (Tailwind, variables y configuración)
│   ├── tailwind.css   # Configuración de Tailwind CSS
├── utils/             # Utilidades y funciones auxiliares
├── main.tsx           # Punto de entrada
```

## Cómo Empezar

1. Clona el repositorio:

   ```bash
   git clone https://github.com/No-Country-simulation/s20-22-webapp.git
   ```

2. Navega a la carpeta del proyecto:
   ```bash
   cd nombre-del-repo
   ```
3. Instala las dependencias
   ```bash
   pnpm install
   ```
4. Inicia la aplicacion:
   ```bash
   pnpm dev
   ```
