package sbnz.cdss.model.dto;

import java.util.List;

public class SymptomDto {
    private Long id;
    private String description;

    public SymptomDto() {
    }

    public SymptomDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
