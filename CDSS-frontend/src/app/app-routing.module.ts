import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {LoginComponent} from './components/login/login.component';
import {HomeComponent} from './components/home/home.component';
import {ServePatientComponent} from './components/serve-patient/serve-patient.component';
import {DoctorComponent} from './components/admin-functions/doctor/doctor.component';
import {PatientComponent} from './components/admin-functions/patient/patient.component';
import {DiseaseComponent} from './components/admin-functions/disease/disease.component';
import {SymptomComponent} from './components/admin-functions/symptom/symptom.component';
import {MedicalComponent} from './components/admin-functions/medical/medical.component';
import {ReportsComponent} from './components/reports/reports.component';


const appRoutes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'serve-patient', component: ServePatientComponent},
  {path: 'admin-operations/new/doctor', component: DoctorComponent},
  {path: 'admin-operations/new/patient', component: PatientComponent},
  {path: 'admin-operations/new/disease', component: DiseaseComponent},
  {path: 'admin-operations/new/symptom', component: SymptomComponent},
  {path: 'admin-operations/new/medical', component: MedicalComponent},
  {path: 'reports' , component: ReportsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
