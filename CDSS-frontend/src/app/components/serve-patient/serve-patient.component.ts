import {Component, OnInit} from '@angular/core';
import {PatientsService} from '../../service/patients.service';
import {forEach} from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-serve-patient',
  templateUrl: './serve-patient.component.html',
  styleUrls: ['./serve-patient.component.css']
})
export class ServePatientComponent implements OnInit {

  constructor(private patientsService: PatientsService) {
  }
  options = false;
  optionClicked = '';
  patientsLoading = false;
  patients: any;
  selectedPatient: any;

  ngOnInit() {
    this.loadPatients();
  }

  private loadPatients() {
    this.patientsLoading = true;
    this.patientsService.getAllPatients().subscribe(result => {
      this.patients = result;
      this.patientsLoading = false;
    });
  }


  customSearchFn(term: string, item: any) {
    term = term.toLocaleLowerCase();
    return item.name.toLocaleLowerCase().indexOf(term) > -1 ||
      item.lastname.toLocaleLowerCase().indexOf(term) > -1 || item.cardNumber.startsWith(term);
  }

  reasonerStart() {
    this.options = true;
    this.optionClicked = 'reasoner';
  }

  getDiseases() {
    this.options = true;
    this.optionClicked = 'diseases';
  }

  getSymptoms() {
    this.options = true;
    this.optionClicked = 'symptoms';
  }

  clickedBack($event) {
    this.options = false;
    this.optionClicked = '';
  }
}
