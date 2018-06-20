package sbnz.cdss.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DiseaseSymptomId
        implements Serializable {

    @Column(name = "disease_id")
    private Long diseaseId;

    @Column(name = "symptom_id")
    private Long symptomId;

    private DiseaseSymptomId() {
    }

    public DiseaseSymptomId(
            Long diseaseId,
            Long symptomId) {
        this.diseaseId = diseaseId;
        this.symptomId = symptomId;
    }

    //Getters omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        DiseaseSymptomId that = (DiseaseSymptomId) o;
        return Objects.equals(diseaseId, that.diseaseId) &&
                Objects.equals(symptomId, that.symptomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diseaseId, symptomId);
    }

    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Long getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Long symptomId) {
        this.symptomId = symptomId;
    }
}
