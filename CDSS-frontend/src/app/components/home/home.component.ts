import {Component, OnInit} from '@angular/core';
import {SecurityUtil} from '../../util/security-util';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public firstname: string;
  public lastname: string;
  public role: string;

  constructor() {
  }

  ngOnInit() {
    this.firstname = SecurityUtil.getFirstName();
    this.lastname = SecurityUtil.getLastName();
    this.role = SecurityUtil.getRole();
  }

}
