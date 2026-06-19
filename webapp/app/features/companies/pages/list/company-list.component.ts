import {Component, inject, OnInit} from "@angular/core";
import {CompanyService} from "../../services/company.service";
import {Company} from "../../models/company.model";
import {CompanyActionsService} from "../../services/company-actions.service";

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  standalone: true,
  imports: [

  ],
})
export default class CompanyListComponent implements OnInit {

 private companyService = inject(CompanyService);
 public companyActionsService = inject(CompanyActionsService);

 companies: Company[] = [];

  ngOnInit(): void {
    this.companyService.findAll()
      .subscribe(data => this.companies = data);
  }

  async edit(id?: number) {
    await this.companyActionsService.goToEdit(id?.toString()!!);
  }

  delete(id?: number) {
    this.companyService.delete(id!!)
      .subscribe(res => res ? this.ngOnInit() : null);
  }

}
