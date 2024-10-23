import { Component, OnInit } from '@angular/core';
import { Company } from './company';
import { CompanyService } from './company.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  companies: Company[] = [];

  constructor(private companyService: CompanyService) {}

  ngOnInit(): void {
    this.companyService.getCompanies().subscribe(companies => {
      this.companies = companies;
    });
  }

  newCompany: Company = new Company(0, '', '', '', 0, 0);

  addCompany() {
    this.companyService.addCompany(this.newCompany).subscribe(id => {
      this.newCompany.id = id;
      this.companies.push(this.newCompany);
      this.newCompany = new Company(0, '', '', '', 0, 0);
    });
  }

  deleteCompany(companyToDelete: Company) {
    console.log("Deleting company with ID:", companyToDelete.id);
    this.companyService.deleteCompany(companyToDelete.id).subscribe(() => {
      this.companies = this.companies.filter(company => company !== companyToDelete);
    });
  }

  triggerUpdate(company: Company) {
    company.editedCompany = new Company(
      company.id,
      company.taxIdentificationNumber,
      company.address,
      company.name,
      company.healthInsurance,
      company.pensionInsurance
    );
    company.editMode = true;
  }

  cancelCompanyUpdate(company: Company) {
    company.editMode = false;
  }

  updateCompany(updatedCompany: Company) {
    this.companyService.editCompany(updatedCompany).subscribe(() => {
      updatedCompany.taxIdentificationNumber = updatedCompany.editedCompany?.taxIdentificationNumber || updatedCompany.taxIdentificationNumber;
      updatedCompany.address = updatedCompany.editedCompany?.address || updatedCompany.address;
      updatedCompany.name = updatedCompany.editedCompany?.name || updatedCompany.name;
      updatedCompany.healthInsurance = updatedCompany.editedCompany?.healthInsurance || updatedCompany.healthInsurance;
      updatedCompany.pensionInsurance = updatedCompany.editedCompany?.pensionInsurance || updatedCompany.pensionInsurance;
      updatedCompany.editMode = false;
    });
  }
}
