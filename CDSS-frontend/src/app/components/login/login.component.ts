import {Component, OnInit} from '@angular/core';
import {ToastrService} from 'ngx-toastr';
import {UserService} from '../../service/user.service';
import {Router} from '@angular/router';
import {NgxPermissionsService} from 'ngx-permissions';
import {SecurityUtil} from '../../util/security-util';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public username: string;
  public password: string;

  constructor(private toastr: ToastrService, private userService: UserService, private router: Router,
              private permissionsService: NgxPermissionsService) {
  }

  ngOnInit() {
  }

  login() {
    console.log(this.username + ',' + this.password);
    this.userService.login(this.username, this.password).subscribe(user => {
      localStorage.setItem('loggedUser', JSON.stringify(user));
      this.router.navigate(['/home']);
      this.toastr.success('You have been successfully logged in!', 'Welcome');
      const role = SecurityUtil.getRole();
      const perm = [];
      perm.push(role);
      this.permissionsService.loadPermissions(perm);
      this.permissionsService.permissions$.subscribe((permisios) => {
      });
    }, () => {
      this.toastr.error('Invalid username or password.Try again!', 'Bad login');
      return;
    });
  }

}
