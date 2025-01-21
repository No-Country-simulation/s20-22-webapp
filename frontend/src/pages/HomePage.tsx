export default function HomePage() {
  // Esta página cambiará eventualmente, de momento queda así para tener una base sobre la cual construir.

  const sampleEvents: any = [
    { id: 1, name: 'Conferencia de Tecnología', date: '2025-02-10' },
    { id: 2, name: 'Taller de Innovación', date: '2025-03-15' },
    { id: 3, name: 'Networking Empresarial', date: '2025-04-20' },
  ];

  const createdEvents: any = [
    { id: 4, name: 'Seminario de Marketing', date: '2025-01-25' },
    { id: 5, name: 'Charla de Liderazgo', date: '2025-01-30' },
  ];

  return (
    <div className="min-h-screen bg-gray-50 text-gray-800">
      {/* Main Content */}
      <main className="container mx-auto px-4 py-8 space-y-8">
        <section>
          <h2 className="text-xl font-semibold mb-4">
            Dashboard de Organizadores
          </h2>
          <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
            {/* Card 1 */}
            <div className="bg-white shadow-md rounded-lg p-6">
              <h3 className="text-lg font-medium mb-2">Eventos Creados</h3>
              <p className="text-sm text-gray-600">
                Eventos que ya han sido organizados.
              </p>
              <ul className="mt-4 space-y-2">
                {createdEvents.map((event: any) => (
                  <li key={event.id} className="border-b pb-2">
                    <p className="text-sm font-semibold">{event.name}</p>
                    <p className="text-xs text-gray-500">Fecha: {event.date}</p>
                  </li>
                ))}
              </ul>
            </div>

            {/* Card 2 */}
            <div className="bg-white shadow-md rounded-lg p-6 flex flex-col items-center justify-center">
              <h3 className="text-lg font-medium mb-6 text-center">
                Crear nuevo evento
              </h3>
              <button
                className="w-16 h-16 rounded-full bg-gray-100 hover:bg-gray-200 
                           flex items-center justify-center text-3xl text-gray-700 
                           shadow-md transition-all duration-200"
              >
                +
              </button>
            </div>

            {/* Card 3 */}
            <div className="bg-white shadow-md rounded-lg p-6">
              <h3 className="text-lg font-medium mb-2">Total de Eventos</h3>
              <p className="text-4xl font-bold text-blue-600 mt-4">
                {sampleEvents.length}
              </p>
            </div>
          </div>
        </section>

        {/* Próximos eventos */}
        <section>
          <h2 className="text-xl font-semibold mb-4">Próximos Eventos</h2>
          <ul className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            {sampleEvents.map((event: any) => (
              <li key={event.id} className="bg-white shadow-md rounded-lg p-6">
                <h3 className="text-lg font-semibold">{event.name}</h3>
                <p className="text-sm text-gray-600 mt-2">
                  Fecha: {event.date}
                </p>
              </li>
            ))}
          </ul>
        </section>

        {/* Explorar */}
        <div className="text-center mt-8">
          <button className="bg-blue-600 text-white py-2 px-4 rounded-md hover:bg-blue-700">
            Explorar Eventos
          </button>
        </div>
      </main>
    </div>
  );
}
