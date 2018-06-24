import {Component, OnInit} from '@angular/core';
import {PatientsService} from '../../service/patients.service';
import {forEach} from '@angular/router/src/utils/collection';
import {DiagnosticService} from '../../service/diagnostic.service';
import {DiseaseService} from '../../service/disease.service';
import {MedicalService} from '../../service/medical.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {SecurityUtil} from '../../util/security-util';

@Component({
  selector: 'app-serve-patient',
  templateUrl: './serve-patient.component.html',
  styleUrls: ['./serve-patient.component.css']
})
export class ServePatientComponent implements OnInit {

  constructor(private patientsService: PatientsService,
              private diagnosticService: DiagnosticService,
              private diseaseService: DiseaseService, private medicalService: MedicalService,
              private router: Router,
              private toast: ToastrService) {
  }

  options = false;
  optionClicked = '';
  patientsLoading = false;
  patients: any;
  selectedPatient: any;
  diseasesLoading = false;
  diseases: any;
  selectedDisease: any;
  medicals: any;
  medicalsSelected: any;
  medicalsLoading = false;
  allergicMedicals: any;
  allMedicalsAfterValidate = [];

  ngOnInit() {
    this.loadPatients();
    this.getAllDiseases();
    this.getAllMedicals();
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

  customSearchFn2(term: string, item: any) {
    term = term.toLocaleLowerCase();
    return item.name.toLocaleLowerCase().indexOf(term) > -1 || item.category.toLocaleLowerCase().startsWith(term);
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

  validate() {
    this.diagnosticService.isAllergicOnSomething(this.selectedPatient, this.medicalsSelected).subscribe(allergicMedicals => {
      this.allMedicalsAfterValidate = [];
      this.allergicMedicals = allergicMedicals;
      this.allMedicalsAfterValidate = this.allMedicalsAfterValidate.concat(this.medicalsSelected);
      for (let i = 0; i < this.allergicMedicals.length; i++) {
        for (let j = 0; j < this.allMedicalsAfterValidate.length; j++) {
          if (this.allMedicalsAfterValidate[j].name === this.allergicMedicals[i].m.name) {
            this.allMedicalsAfterValidate.splice(j, 1);
            break;
          }
        }
      }
    });
  }

  getAllDiseases() {
    this.diseaseService.getAllDiseases().subscribe(diseases => {
      this.diseases = diseases;
    });
  }

  getAllMedicals() {
    this.medicalService.getAllMedicals().subscribe(medicals => {
      this.medicals = medicals;
    });
  }

  finish() {
    this.router.navigate(['/home']);
    this.diagnosticService.addExamination(this.selectedPatient, this.selectedDisease, this.medicalsSelected, SecurityUtil.getUser()).subscribe(value => {
      this.toast.success('You have successfully finished examination!', 'Finished');
    }, error1 => {
      this.toast.error('Ups!', ':(');

    });
  }
}
