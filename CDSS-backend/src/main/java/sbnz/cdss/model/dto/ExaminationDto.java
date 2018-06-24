package sbnz.cdss.model.dto;

import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.model.entity.Medical;
import sbnz.cdss.model.entity.User;

import java.util.Date;
import java.util.List;

public class ExaminationDto {

    private Long id;

    private PatientDto patient;

    private Date date;

    private User doctor;

    private Disease disease;

    private List<Medical> medicals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public List<Medical> getMedicals() {
        return medicals;
    }

    public void setMedicals(List<Medical> medicals) {
        this.medicals = medicals;
    }

    public ExaminationDto(Long id, PatientDto patient, Date date, User doctor, Disease disease, List<Medical> medicals) {
        this.id = id;
        this.patient = patient;
        this.date = date;
        this.doctor = doctor;
        this.disease = disease;
        this.medicals = medicals;
    }

    public ExaminationDto() {
    }
}