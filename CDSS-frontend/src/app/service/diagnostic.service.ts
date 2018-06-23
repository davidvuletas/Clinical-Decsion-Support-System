import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DiagnosticService {

  constructor(private http: HttpClient) {
  }

  startReasoner(symptoms, patient) {
    const symptomsForSearch = {'symptoms': symptoms, 'patientDto': patient};
    return this.http.post('/api/reasoner/find-disease/priority', symptomsForSearch, {responseType: 'text'});
  }

  getAllDiseasesLinked(symptoms, patient) {
    const symptomsForSearch = {'symptoms': symptoms, 'patientDto': patient};
    return this.http.post('/api/diseases/find-all/linked-by-symptoms', symptomsForSearch);
  }

  getAllSymptomsByDisease(disease) {
    const diseaseQueryDto = {'diseaseName': disease};
    return this.http.post('/api/diseases/find-all/symptoms/by-disease', diseaseQueryDto);
  }
}
