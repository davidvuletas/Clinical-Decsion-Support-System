package sbnz.cdss.model.dto;

import java.util.List;

public class DiseaseDto {

    private Long id;
    private String name;
    List<SymptomDto> symptoms;

    public DiseaseDto(Long id, String name, List<SymptomDto> symptoms) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
    }


    public DiseaseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SymptomDto> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<SymptomDto> symptoms) {
        this.symptoms = symptoms;
    }
}
