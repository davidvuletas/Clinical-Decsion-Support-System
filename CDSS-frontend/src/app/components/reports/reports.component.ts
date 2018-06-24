import {Component, OnInit} from '@angular/core';
import {ReportsService} from '../../service/reports.service';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {

  weakenedPatients: any;
  addictedPatients: any;
  chronicallyPatients: any;

  constructor(private reportService: ReportsService) {
  }

  ngOnInit() {
    this.getAllWeakenedPatients();
    this.getAllAddictedPatients();
    this.getAllChronicallyPatients();
  }


  private getAllChronicallyPatients() {
    // this.reportService.getChronicallyPatients().subscribe(patients => {
    //   this.chronicallyPatients = patients;
    // })
    this.chronicallyPatients = [];
    const p1 = {name: 'Pera', lastname: 'Peric', cardNumber: '123456789'};
    const p2 = {name: 'Marko', lastname: 'Markovic', cardNumber: '345678912'};
    const p3 = {name: 'Darko', lastname: 'Darkovic', cardNumber: '678912345'};
    this.chronicallyPatients.push(p1);
    this.chronicallyPatients.push(p2);
    this.chronicallyPatients.push(p3);
  }

  private getAllAddictedPatients() {
    // this.reportService.getAddictedPatients().subscribe(patients => {
    //   this.addictedPatients = patients;
    // });
    this.addictedPatients = [];
    const p6 = {name: 'Darko', lastname: 'Darkovic', cardNumber: '678912345'};
    const p3 = {name: 'Marko', lastname: 'Markovic', cardNumber: '345678912'};
    const p5 = {name: 'Mika', lastname: 'Mikic', cardNumber: '567891234'};
    const p2 = {name: 'Jova', lastname: 'Jovic', cardNumber: '234567891'};
    const p1 = {name: 'Pera', lastname: 'Peric', cardNumber: '123456789'};
    const p4 = {name: 'Mira', lastname: 'Gvozdenac', cardNumber: '456789123'};

    this.addictedPatients.push(p6);
    this.addictedPatients.push(p3);
    this.addictedPatients.push(p5);
    this.addictedPatients.push(p2);
    this.addictedPatients.push(p1);
    this.addictedPatients.push(p4);


  }

  private getAllWeakenedPatients() {
    // this.reportService.getWeakenedPatients().subscribe(patients => {
    //    this.weakenedPatients = patients;
    // });
    this.weakenedPatients = [];
    const p1 = {name: 'Pera', lastname: 'Peric', cardNumber: '123456789'};
    const p4 = {name: 'Mira', lastname: 'Gvozdenac', cardNumber: '456789123'};

    this.weakenedPatients.push(p1);
    this.weakenedPatients.push(p4);

  }
}
