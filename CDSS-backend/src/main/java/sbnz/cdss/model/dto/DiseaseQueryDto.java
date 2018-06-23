package sbnz.cdss.model.dto;

import java.util.List;

public class DiseaseQueryDto {

    private String diseaseName;
    private List<SymptomWithSpecificVal> symptoms;

    public DiseaseQueryDto() {
    }

    public DiseaseQueryDto(String diseaseName, List<SymptomWithSpecificVal> symptoms) {
        this.diseaseName = diseaseName;
        this.symptoms = symptoms;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public List<SymptomWithSpecificVal> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<SymptomWithSpecificVal> symptoms) {
        this.symptoms = symptoms;
    }
}
