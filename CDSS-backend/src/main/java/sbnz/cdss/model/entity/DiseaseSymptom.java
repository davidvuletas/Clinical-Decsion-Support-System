package sbnz.cdss.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "disease_symptom")
public class  DiseaseSymptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symptom_id")
    private Symptom symptom;

    @Column(name = "general")
    private boolean general;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiseaseSymptom(Disease disease, Symptom symptom, boolean general) {
        this.disease = disease;
        this.symptom = symptom;
        this.general = general;
    }

    public DiseaseSymptom() {
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public boolean isGeneral() {
        return general;
    }

    public void setGeneral(boolean general) {
        this.general = general;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiseaseSymptom that = (DiseaseSymptom) o;
        return general == that.general &&
                Objects.equals(id, that.id) &&
                Objects.equals(disease, that.disease) &&
                Objects.equals(symptom, that.symptom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, disease, symptom, general);
    }
}
