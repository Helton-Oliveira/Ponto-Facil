import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Company, ICompany} from '../models/company.model';

type EntityResponseType = ICompany
type EntityArrayResponseType = ICompany[]

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  private _http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/companies';

  findAll(): Observable<EntityArrayResponseType> {
    return this._http.get<EntityArrayResponseType>(this.apiUrl);
  }

  findById(id: number): Observable<EntityResponseType> {
    return this._http.get<EntityResponseType>(`${this.apiUrl}/${id}`);
  }

  create(company: Company): Observable<EntityResponseType> {
    return this._http.post<EntityResponseType>(this.apiUrl, company);
  }

  update(company: Company): Observable<EntityResponseType> {
    return this._http.put<EntityResponseType>(this.apiUrl, company);
  }

  delete(id: number): Observable<Boolean> {
    return this._http.delete<Boolean>(`${this.apiUrl}/${id}`);
  }
}
