export default function HomePage() {
  // Esta página cambiará eventualmente, de momento queda así para tener una base sobre la cual construir.

  const sampleEvents: any = [
    { id: 1, name: 'Conferencia de Tecnología', date: '2025-02-10' },
    { id: 2, name: 'Taller de Innovación', date: '2025-03-15' },
    { id: 3, name: 'Networking Empresarial', date: '2025-04-20' },
  ];

  return (
    <>
      <div>
        <section>
          <h2>Bienvenido a la plataforma de eventos</h2>
          <p>
            Organiza, gestiona y participa en eventos de manera sencilla y
            eficiente.
          </p>
          <button>Explorar Eventos</button>
        </section>

        <section>
          <h2>Próximos Eventos</h2>
          <ul>
            {sampleEvents.map((event: any) => (
              <li key={event.id}>
                <h3>{event.name}</h3>
                <p>Fecha: {event.date}</p>
              </li>
            ))}
          </ul>
        </section>
      </div>
    </>
  );
}
