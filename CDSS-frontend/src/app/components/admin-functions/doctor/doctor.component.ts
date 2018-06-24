import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../service/user.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  user: any;
  doctors: any;

  constructor(private userService: UserService, private toastr: ToastrService) {
  }

  ngOnInit() {
    this.user = {username: 'username', password: 'password', firstname: '', lastname: ''};
    this.loadDoctors();
  }

  addDoctor() {
    this.userService.addDoctor(this.user).subscribe(regs => {
      this.toastr.success('Doctor ' + this.user.firstname + ' are added successfully!');
      this.doctors.push(this.user);
    }, error1 => {
      console.log(error1)
      this.toastr.error('Already exist doctor with this username!');
    });
  }

  loadDoctors() {
    this.userService.getAllDoctors().subscribe(doctors => {
      console.log(doctors);
      this.doctors = doctors;
    });
  }
}
