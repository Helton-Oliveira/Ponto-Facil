import {Component} from '@angular/core';
import {RouterLink, RouterLinkActive} from '@angular/router';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {faBuilding} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, FontAwesomeModule],
  template: `
    <main class="w-64 h-screen bg-sidebar flex flex-col border-r border-neutral-800 font-sans">
      <!-- 1. Cabeçalho / Logo -->
      <div class="px-6 py-8 border-b border-neutral-800">
        <h1 class="text-white text-2xl font-bold tracking-tight">
          Ponto<span class="text-brand">Fácil</span>
        </h1>
      </div>

      <nav className="flex-1 px-4 py-6 overflow-y-auto">

       <!-- <div class="flex items-center justify-center w-full mb-10 overflow-hidden">
          <img
            ngSrc="../assets/logo.png"
            alt="Logo"
            class="h-20 min-w-20 w-full "
            width="1000"
            height="1000"
          />
        </div> -->

        <ul class="flex flex-col gap-2 w-full">

            <li class="w-full p-4 items-center gp-2">
              <a routerLink="/companies" routerLinkActive="bg-grey-200 text-white"
                 className="flex items-center px-4 py-3 rounded-lg text-gray-400 hover:bg-sidebar-soft transition-all">

                <i class="fa-solid fa-building text-xl w-8 text-center"></i>

                <span class="font-medium text-sm">Empresas</span>
              </a>
            </li>

        </ul>
      </nav>

      <!-- 3. Rodapé / Configurações -->
      <div class="p-4 border-t border-neutral-800 items-end">
        <a
          href="#"
          class="flex items-center px-4 py-3 rounded-lg text-gray-400 hover:bg-sidebar-soft transition-all"
        >
          <span class="font-medium text-sm">Configurações</span>
        </a>
      </div>
    </main>
  `
})
export class SidebarComponent {
  faBuilding = faBuilding;
}
