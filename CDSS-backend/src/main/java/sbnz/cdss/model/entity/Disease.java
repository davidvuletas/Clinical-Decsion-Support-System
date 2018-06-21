package sbnz.cdss.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    @Enumerated(value = EnumType.STRING)
    private DiseaseCategory disaeseCategory;

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

    public DiseaseCategory getDisaeseCategory() {
        return disaeseCategory;
    }

    public void setDisaeseCategory(DiseaseCategory disaeseCategory) {
        this.disaeseCategory = disaeseCategory;
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
}
