import {Component, OnInit} from '@angular/core';
import {PatientsService} from '../../../service/patients.service';
import {ToastrService} from 'ngx-toastr';
import {DiseaseService} from '../../../service/disease.service';
import {SymptomService} from '../../../service/symptom.service';

@Component({
  selector: 'app-disease',
  templateUrl: './disease.component.html',
  styleUrls: ['./disease.component.css']
})
export class DiseaseComponent implements OnInit {

  disease: any;
  diseases: any;
  symptoms: any;

  constructor(private diseaseService: DiseaseService, private toastr: ToastrService, private symptomService: SymptomService) {

  }

  ngOnInit() {
    this.disease = {name: '', symptoms: []};
    this.loadSymptoms();
    this.loadDiseases();
  }


  loadSymptoms() {
    this.symptomService.getAllSymptoms().subscribe(symptoms => {
      this.symptoms = symptoms;
    });
  }

  loadDiseases() {
    this.diseaseService.getAllDiseases().subscribe(diseases => {
      this.diseases = diseases;
    });
  }


  addDisease() {
    this.diseaseService.addDisease(this.disease).subscribe(res => {
      this.toastr.success('Disease ' + this.disease.name + ' are added successfully!');
      this.diseases.push(this.disease);
    });
  }

}
