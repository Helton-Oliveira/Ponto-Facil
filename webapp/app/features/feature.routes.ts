import { Routes } from '@angular/router';

export const FEATURE_ROUTES: Routes = [
  {
    path: 'companies',
    loadChildren: () => import('./companies/company.routes').then(m => m.COMPANY_ROUTES)
  }
];
