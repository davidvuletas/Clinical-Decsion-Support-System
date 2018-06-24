import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReportsService {

  constructor(private http: HttpClient) { }

  getAddictedPatients() {
    return this.http.get('/api/reasoner/report/patients/addicted');
  }

  getChronicallyPatients() {
    return this.http.get('/api/reasoner/report/patients/chronic-disease');
  }

  getWeakenedPatients() {
    return this.http.get('/api/reasoner/report/patients/weakened-immune');
  }
}
