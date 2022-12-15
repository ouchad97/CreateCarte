import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CarteService {
  private baseUrl = `${environment.apiUrl}`;

  constructor(private http: HttpClient) { }

  createCarte(data: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, data);
  }

  getCarte(idCarte: Number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${idCarte}`);
  }

  getCartesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
