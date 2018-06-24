package sbnz.cdss.model.dto;

import sbnz.cdss.model.entity.Medical;

import java.util.List;

public class PatientAndMedicals {
    private PatientDto patientDto;
    private List<Medical> medicals;

    public PatientDto getPatientDto() {
        return patientDto;
    }

    public void setPatientDto(PatientDto patientDto) {
        this.patientDto = patientDto;
    }

    public List<Medical> getMedicals() {
        return medicals;
    }

    public void setMedicals(List<Medical> medicals) {
        this.medicals = medicals;
    }
}
