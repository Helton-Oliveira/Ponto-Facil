import {Routes} from '@angular/router';
import {FEATURE_ROUTES} from './features/feature.routes';

export const APP_ROUTES: Routes = [
  ...FEATURE_ROUTES,
  {
    path: '',
    redirectTo: 'companies',
    pathMatch: 'full'
  }
];
