import {Routes} from '@angular/router';
import CompanyListComponent from "./pages/list/company-list.component";
import CompanyUpdateComponent from "./pages/update/company-update.component";

export const COMPANY_ROUTES: Routes = [
  {
    path: '',
    component: CompanyListComponent
  },
  {
    path: 'new',
    component: CompanyUpdateComponent
  },
  {
    path: 'edit/:id',
    component: CompanyUpdateComponent
  },
  {
    path: 'details',
    component: CompanyListComponent
  }
];
