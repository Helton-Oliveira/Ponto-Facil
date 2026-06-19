import {Component, inject, OnInit} from "@angular/core";
import {CompanyService} from "../../services/company.service";
import {Company} from "../../models/company.model";
import {CompanyActionsService} from "../../services/company-actions.service";
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {Address} from "../../models/address";

@Component({
  selector: 'app-company-update',
  templateUrl: './company-update.component.html',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
})
export default class CompanyUpdateComponent implements OnInit {

 private fb = inject(FormBuilder);
 private route = inject(ActivatedRoute);
 private companyService = inject(CompanyService);
 private companyActionsService = inject(CompanyActionsService);

 company: Company = new Company();

  form = this.fb.group({
    id: ['', Validators.required],
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    phone: ['', [Validators.required, Validators.minLength(6)]],
    image: ['', Validators.required],
    street: ['', Validators.required],
    number: ['', Validators.required],
    neighborhood: ['', Validators.required],
    city: ['', Validators.required],
    uf: ['', Validators.required],
    zipcode: ['', Validators.required],
  });

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.companyService.findById(id)
        .subscribe((res) => {
          this.company = res;
          this.updateForm();
        })
    }
    this.form.get('id')?.disable();
  }

  updateForm() {
    this.form.patchValue({
      id: String(this.company?.id),
      name: this.company.name,
      email: this.company.email,
      phone: this.company.phone,
      image: this.company.image,
      street: this.company.address?.street,
      number: this.company.address?.number,
      neighborhood: this.company.address?.neighborhood,
      uf: this.company.address?.UF,
      city: this.company.address?.city,
    });
  }

  private updateCompany() {
    this.company = {
      ...this.company,
      name: this.form.value.name,
      email: this.form.value.email,
      phone: this.form.value.phone,
      image: this.form.value.image,
      address: {
        ...this.updateAddress(),
      }
    } as Company

    this.company.edited = true;
  }

  private updateAddress(): Address {
    return {
      street: this.form.value.street,
      number: this.form.value.number,
      neighborhood: this.form.value.neighborhood,
      city: this.form.value.city,
      UF: this.form.value.uf
    } as Address
  }

  async onSave($event: Event) {
    $event.stopPropagation();

    const canId = this.company?.id != null;

    switch (canId) {
      case false:
        this.updateCompany();
        this.companyService.create(this.company)
          .subscribe(async () =>
            await this.companyActionsService.goToList()
          )
        break;

      case true:
        this.updateCompany();
        this.companyService.update(this.company)
          .subscribe(async () => await this.companyActionsService.goToList());
        break;
    }

  }

  async goToList() {
    await this.companyActionsService.goToList();
  }

}
