import {Component, OnInit} from '@angular/core';
import {NgxPermissionsService} from 'ngx-permissions';
import {SecurityUtil} from '../../util/security-util';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public role: string;

  constructor(private permissionsService: NgxPermissionsService, private router: Router) {
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
  }
}
