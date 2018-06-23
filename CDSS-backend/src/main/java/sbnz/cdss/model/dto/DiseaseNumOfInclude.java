package sbnz.cdss.model.dto;

import sbnz.cdss.model.entity.Disease;

public class DiseaseNumOfInclude {

    private String disease;
    private int number;

    public DiseaseNumOfInclude() {
    }

    public DiseaseNumOfInclude(String disease, int number) {
        this.disease = disease;
        this.number = number;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
