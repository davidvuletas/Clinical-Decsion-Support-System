package sbnz.cdss.model.dto;

import sbnz.cdss.model.entity.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SymptomsForSearch {

    private List<String> symptoms;
    private PatientDto patientDto;
    private Patient patient;
    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SymptomsForSearch() {
        this.symptoms = new ArrayList<>();
        this.date = new Date();
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public PatientDto getPatientDto() {
        return patientDto;
    }

    public void setPatientDto(PatientDto patientDto) {
        this.patientDto = patientDto;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
