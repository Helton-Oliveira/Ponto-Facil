import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {SidebarComponent} from './shared/components/sidebar/sidebar.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SidebarComponent],
  template: `
    <div class="flex h-screen bg-black text-white">
      <app-sidebar></app-sidebar>
      <main class="flex-1 overflow-auto p-8">
        <router-outlet></router-outlet>
      </main>
    </div>
  `
})
export class AppComponent {}
