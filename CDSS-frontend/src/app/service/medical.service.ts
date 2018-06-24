import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MedicalService {

  constructor(private http: HttpClient) {
  }

  getAllMedicals() {
    return this.http.get('/api/medicals');
  }

  addMedical(medical) {
    return this.http.post('/api/medicals', medical);
  }
}
