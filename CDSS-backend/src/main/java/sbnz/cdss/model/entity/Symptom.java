package sbnz.cdss.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "symptom")
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToMany(
            mappedBy = "symptom",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DiseaseSymptom> diseases;
    public Symptom() {
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

    public List<DiseaseSymptom> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<DiseaseSymptom> diseases) {
        this.diseases = diseases;
    }
}
