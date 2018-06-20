import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServePatientComponent } from './serve-patient.component';

describe('ServePatientComponent', () => {
  let component: ServePatientComponent;
  let fixture: ComponentFixture<ServePatientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServePatientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServePatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
