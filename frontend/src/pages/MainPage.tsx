import "../styles/HomePage.css";

export default function HomePage() {
  const sampleEvents = [
    { id: 1, name: "Conferencia de Tecnología", date: "2025-02-10" },
    { id: 2, name: "Taller de Innovación", date: "2025-03-15" },
    { id: 3, name: "Networking Empresarial", date: "2025-04-20" },
  ];

  return (
    <div className="homepage">
      {/* Header */}
      <header className="header">
        <h1>Eventix</h1>
        <nav>
          <a href="#about">Acerca de</a>
          <a href="#events">Eventos</a>
          <a href="#contact">Contacto</a>
        </nav>
        <button className="login-button">Iniciar Sesión</button>
      </header>

      {/* Principal */}
      <section id="about" className="main-section">
        <h2 className="sub">Bienvenido a la plataforma de eventos</h2>
        <p>
          Organiza, gestiona y participa en eventos de manera sencilla y
          eficiente.
        </p>
        <button className="cta-button">Explorar Eventos</button>
      </section>

      {/* Eventos */}
      <section id="events" className="events-section">
        <h2>Próximos Eventos</h2>
        <ul className="events-list">
          {sampleEvents.map((event) => (
            <li key={event.id} className="event-item">
              <h3>{event.name}</h3>
              <p>Fecha: {event.date}</p>
            </li>
          ))}
        </ul>
      </section>

      {/* Footer */}
      <footer className="footer">
        <p>
          © 2025 Sistema de Gestión de Eventos. Todos los derechos reservados.
        </p>
        <nav>
          <a href="#privacy">Política de Privacidad</a>
          <a href="#terms">Términos de Servicio</a>
        </nav>
      </footer>
    </div>
  );
}
