package sbnz.cdss.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
    @JsonIgnore
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

    @Override
    public String toString() {
        return "Symptom{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptom symptom = (Symptom) o;
        return Objects.equals(id, symptom.id) &&
                Objects.equals(description, symptom.description) &&
                Objects.equals(diseases, symptom.diseases);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description, diseases);
    }
}
