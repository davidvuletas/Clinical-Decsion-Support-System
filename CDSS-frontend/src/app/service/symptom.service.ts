import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SymptomService {

  constructor(private http: HttpClient) {
  }

  getAllSymptoms() {
    return this.http.get('/api/symptoms');
  }

  addSymptom(symptom) {
    return this.http.post('/api/symptoms', symptom);
  }
}
