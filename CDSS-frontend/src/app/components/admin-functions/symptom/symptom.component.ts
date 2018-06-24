import {Component, OnInit} from '@angular/core';
import {PatientsService} from '../../../service/patients.service';
import {ToastrService} from 'ngx-toastr';
import {SymptomService} from '../../../service/symptom.service';

@Component({
  selector: 'app-symptom',
  templateUrl: './symptom.component.html',
  styleUrls: ['./symptom.component.css']
})
export class SymptomComponent implements OnInit {

  symptom: any;
  symptoms: any;

  constructor(private patientService: PatientsService, private toastr: ToastrService, private symptomService: SymptomService) {

  }

  ngOnInit() {
    this.symptom = {description: ''};
    this.loadSymptoms();
  }


  loadSymptoms() {
    this.symptomService.getAllSymptoms().subscribe(symptoms => {
      this.symptoms = symptoms;
    });
  }

  addSymptom() {
    this.symptomService.addSymptom(this.symptom).subscribe(res => {
      this.toastr.success('Symptom ' + this.symptom.description + ' are added successfully!');
      this.symptoms.push(this.symptom);
    });
  }
}
