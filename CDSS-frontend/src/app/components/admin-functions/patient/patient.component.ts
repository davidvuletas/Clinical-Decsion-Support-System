import {Component, OnInit} from '@angular/core';
import {ToastrService} from 'ngx-toastr';
import {UserService} from '../../../service/user.service';
import {PatientsService} from '../../../service/patients.service';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {
  user: any;
  patients: any;

  constructor(private patientService: PatientsService, private toastr: ToastrService) {

  }

  ngOnInit() {
    this.user = {name: '', lastname: '', cardNumber: ''};
    this.loadPatients();
  }


  loadPatients() {
    this.patientService.getAllPatients().subscribe(patients => {
      this.patients = patients;
    });
  }

  addTag(name) {
    return name;
  }

  addPatient() {
    this.patientService.addPatient(this.user).subscribe(res => {
      this.toastr.success('Patient ' + this.user.name + ' are added successfully!');
      this.patients.push(this.user);
    });
  }
}
