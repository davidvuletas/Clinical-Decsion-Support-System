package sbnz.cdss.model.entity;

import sbnz.cdss.model.dto.DiseaseDto;
import sbnz.cdss.model.dto.SymptomDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    @Enumerated(value = EnumType.STRING)
    private DiseaseCategory diseaseCategory;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "disease",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DiseaseSymptom> symptoms;

    public Disease() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiseaseCategory getDiseaseCategory() {
        return diseaseCategory;
    }

    public void setDiseaseCategory(DiseaseCategory diseaseCategory) {
        this.diseaseCategory = diseaseCategory;
    }

    public List<DiseaseSymptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<DiseaseSymptom> symptoms) {
        this.symptoms = symptoms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", diseaseCategory=" + diseaseCategory +
                ", name='" + name + '\'' +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disease disease = (Disease) o;
        return Objects.equals(id, disease.id) &&
                diseaseCategory == disease.diseaseCategory &&
                Objects.equals(name, disease.name) &&
                Objects.equals(symptoms, disease.symptoms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, diseaseCategory, name, symptoms);
    }

    public DiseaseDto toDto() {
        DiseaseDto diseaseDto = new DiseaseDto();
        diseaseDto.setId(this.getId());
        diseaseDto.setName(this.getName());
        List<SymptomDto> symptomDtos = new ArrayList<>();
        for(DiseaseSymptom ds : this.symptoms) {
            symptomDtos.add(new SymptomDto(ds.getSymptom().getId(),ds.getSymptom().getDescription()));
        }
        diseaseDto.setSymptoms(symptomDtos);
        return diseaseDto;
    }
}
