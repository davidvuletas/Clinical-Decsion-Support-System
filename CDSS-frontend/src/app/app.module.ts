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
import {NgSelectModule} from '@ng-select/ng-select';
import { DiagnosticOptionsComponent } from './components/diagnostic-options/diagnostic-options.component';
import { DoctorComponent } from './components/admin-functions/doctor/doctor.component';
import { DiseaseComponent } from './components/admin-functions/disease/disease.component';
import { MedicalComponent } from './components/admin-functions/medical/medical.component';
import { PatientComponent } from './components/admin-functions/patient/patient.component';
import { SymptomComponent } from './components/admin-functions/symptom/symptom.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    ServePatientComponent,
    DiagnosticOptionsComponent,
    DoctorComponent,
    DiseaseComponent,
    MedicalComponent,
    PatientComponent,
    SymptomComponent
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
    ArchwizardModule,
    NgSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
