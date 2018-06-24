import { Component, OnInit } from '@angular/core';
import {DiseaseService} from '../../../service/disease.service';
import {SymptomService} from '../../../service/symptom.service';
import {ToastrService} from 'ngx-toastr';
import {MedicalService} from '../../../service/medical.service';

@Component({
  selector: 'app-medical',
  templateUrl: './medical.component.html',
  styleUrls: ['./medical.component.css']
})
export class MedicalComponent implements OnInit {

  medical: any;
  medicals: any;

  constructor(private medicalService: MedicalService, private toastr: ToastrService) {

  }

  ngOnInit() {
    this.medical = {name: '', ingredients: [], category: ''};
    this.loadMedicals();
  }

  addTag(name) {
    return name;
  }

  loadMedicals() {
    this.medicalService.getAllMedicals().subscribe(medicals => {
      this.medicals = medicals;
    });
  }

  addMedical() {
    console.log(this.medical)
    this.medicalService.addMedical(this.medical).subscribe(res => {
      this.toastr.success('Medical ' + this.medical.name + ' are added successfully!');
      this.medicals.push(this.medical);
    });
  }

}
