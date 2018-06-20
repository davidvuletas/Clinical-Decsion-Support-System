package sbnz.cdss.model.dto;

import sbnz.cdss.model.entity.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SymptomsForSearch {

    private List<String> symptoms;
    private Patient patient;
    private Date date = new Date();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SymptomsForSearch() {
        this.symptoms = new ArrayList<>();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }
}
