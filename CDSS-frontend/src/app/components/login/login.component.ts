import {Component, OnInit} from '@angular/core';
import {ToastrService} from 'ngx-toastr';
import {UserService} from '../../service/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public username: string;
  public password: string;

  constructor(private toastr: ToastrService, private userService: UserService, private router: Router) {
  }

  ngOnInit() {
  }

  login() {
    console.log(this.username + ',' + this.password);
    this.userService.login(this.username, this.password).subscribe(user => {
      localStorage.setItem('loggedUser', JSON.stringify(user));
      this.router.navigate(['/home']);
      this.toastr.success('You have been successfully logged in!', 'Welcome');
    }, () => {
      this.toastr.error('Invalid username or password.Try again!', 'Bad login');
      return;
    });
  }

}
