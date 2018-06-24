import {Component, OnInit} from '@angular/core';
import {NgxPermissionsService} from 'ngx-permissions';
import {SecurityUtil} from '../../util/security-util';
import {Router} from '@angular/router';
import {UserService} from '../../service/user.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  private serverUrl = 'http://localhost:8080/socket';
  private title = 'WebSockets chat';
  private stompClient;
  public role: string;

  constructor(private permissionsService: NgxPermissionsService, private router: Router,
              private  userService: UserService, private toastr: ToastrService) {
    this.role = '';

  }

  ngOnInit() {
    this.role = SecurityUtil.getRole();
    const perm = [];
    perm.push(this.role);
    this.permissionsService.loadPermissions(perm);
    this.permissionsService.permissions$.subscribe((permisios) => {
    });
    console.log(this.permissionsService.getPermissions());
  }

  logout() {
    SecurityUtil.isEmpty();
    this.permissionsService.loadPermissions(['GUEST']);
    this.permissionsService.permissions$.subscribe();
    this.router.navigate(['/login']);
    this.userService.logout().subscribe();
  }
}
