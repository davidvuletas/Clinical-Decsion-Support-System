import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DiseaseService {

  constructor(private http: HttpClient) {
  }

  getAllDiseases() {
    return this.http.get('/api/diseases');
  }

  addDisease(disease) {
    return this.http.post('/api/diseases', disease);
  }
}
