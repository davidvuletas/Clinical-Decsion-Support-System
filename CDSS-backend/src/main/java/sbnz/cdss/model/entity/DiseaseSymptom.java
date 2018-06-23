package sbnz.cdss.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "disease_symptom")
public class  DiseaseSymptom {

    @EmbeddedId
    private DiseaseSymptomId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("diseaseId")
    private Disease disease;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("symptomId")
    private Symptom symptom;

    @Column(name = "general")
    private boolean general;

    public DiseaseSymptomId getId() {
        return id;
    }

    public void setId(DiseaseSymptomId id) {
        this.id = id;
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



}
