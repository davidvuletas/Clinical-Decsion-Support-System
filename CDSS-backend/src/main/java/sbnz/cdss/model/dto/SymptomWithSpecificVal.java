package sbnz.cdss.model.dto;

public class SymptomWithSpecificVal {
    private String symptom;
    private boolean specific;

    public SymptomWithSpecificVal() {
    }

    public SymptomWithSpecificVal(String symptom, boolean specific) {
        this.symptom = symptom;
        this.specific = specific;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public boolean isSpecific() {
        return specific;
    }

    public void setSpecific(boolean specific) {
        this.specific = specific;
    }
}
