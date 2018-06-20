import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import {NgxPermissionsModule} from 'ngx-permissions';
import { HomeComponent } from './components/home/home.component';
import {ToastrModule} from 'ngx-toastr';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { ServePatientComponent } from './components/serve-patient/serve-patient.component';
import {ArchwizardModule} from 'angular-archwizard';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    ServePatientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPermissionsModule.forRoot(),
    ToastrModule.forRoot({
      preventDuplicates: true,
    }),
    BrowserAnimationsModule, // required animations module
    ArchwizardModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }