import {Injectable} from "@angular/core";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class CompanyActionsService {

  constructor(
    private router: Router
  ) {
  }

  async goToNew() {
    await this.router.navigate(['companies', 'new']);
  }

  async goToEdit(id: string) {
    await this.router.navigate(['companies', 'edit', id]);
  }

  async goToList() {
    await this.router.navigate(['companies']);
  }

  async goToDetail() {
    await this.router.navigate(['companies', 'detail']);
  }

}
