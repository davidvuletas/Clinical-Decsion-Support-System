import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {DiagnosticService} from '../../service/diagnostic.service';
import {SymptomService} from '../../service/symptom.service';
import {DiseaseService} from '../../service/disease.service';

@Component({
  selector: 'app-diagnostic-options',
  templateUrl: './diagnostic-options.component.html',
  styleUrls: ['./diagnostic-options.component.css']
})
export class DiagnosticOptionsComponent implements OnInit {
  @Input() user: any;
  @Input() type: any;
  @Output() backClicked: EventEmitter<any> = new EventEmitter();

  selectedSymptoms = [];
  symptoms: any;
  disease: string;
  diseases: any;
  initialDiseases: any;
  diseaseLoading: any;
  selectedDisease: any;
  resultedSymptoms: any;
  constructor(private diagnosticService: DiagnosticService, private symptomService: SymptomService,
              private diseaseService: DiseaseService) {
  }


  ngOnInit() {
    console.log(this.user + ',' + this.type);
    if (this.type === 'reasoner' || this.type === 'diseases') {
      this.getAllSymptoms();
    } else {
      this.getInitialAllDiseases();
    }
  }

  back() {
    this.backClicked.emit(true);
  }

  getAllSymptoms() {
    this.symptomService.getAllSymptoms().subscribe(symptoms => {
      this.symptoms = symptoms;
    });
  }

  startReasoner() {
    const symptomsForSend = [];
    for (const s of this.selectedSymptoms) {
      symptomsForSend.push(s.description);
    }
    this.diagnosticService.startReasoner(symptomsForSend, this.user).subscribe(disease => {
      this.disease = disease.toString();
    });
  }


  getInitialAllDiseases() {
    this.diseaseService.getAllDiseases().subscribe(initDiseases => {
      this.initialDiseases = initDiseases;
    });
  }

  getAllDiseasesLinked() {
    const symptomsForSend = [];
    for (const s of this.selectedSymptoms) {
      symptomsForSend.push(s.description);
    }
    this.diagnosticService.getAllDiseasesLinked(symptomsForSend, this.user).subscribe(diseases => {
      this.diseases = diseases;
    });
  }

  getAllSymptomsWithGenerality() {
    this.diagnosticService.getAllSymptomsByDisease(this.selectedDisease.name).subscribe(symptoms => {
      this.resultedSymptoms = symptoms;
    });
  }
}
