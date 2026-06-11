import Link from 'next/link';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBuilding } from '@fortawesome/free-solid-svg-icons';

export default function Sidebar() {
  return (
    <main className="w-64 h-screen bg-sidebar flex flex-col border-r border-neutral-800 font-sans">
      {/* 1. Cabeçalho / Logo */}
      <div className="px-6 py-8 border-b border-neutral-800">
        <h1 className="text-white text-2xl font-bold tracking-tight">
          Ponto<span className="text-brand">Fácil</span>
        </h1>
      </div>

      {/* 2. Navegação Principal */}
      <nav className="flex-1 px-4 py-6 overflow-y-auto">
        <ul className="flex flex-col gap-2">
          {/* Item ATIVO (Usando sua classe global bg-sidebar-soft) */}
          <li>
            <Link
              href="/company"
              className="flex items-center px-4 py-3 justify-around rounded-lg bg-sidebar-soft transition-all"
            >
              <FontAwesomeIcon icon={faBuilding} />
              <span className="font-medium">Empresas</span>
            </Link>
          </li>

          {/* Item INATIVO */}
          <li>
            <a
              href="#"
              className="flex items-center px-4 py-3 rounded-lg text-gray-400 hover:bg-sidebar-soft transition-all"
            >
              <span className="font-medium">Veículos</span>
            </a>
          </li>
        </ul>
      </nav>

      {/* 3. Rodapé / Configurações (Fica fixo na base) */}
      <div className="p-4 border-t border-neutral-800">
        <a
          href="#"
          className="flex items-center px-4 py-3 rounded-lg text-gray-400 hover:bg-sidebar-soft transition-all"
        >
          <span className="font-medium text-sm">Configurações</span>
        </a>
      </div>
    </main>
  );
}
