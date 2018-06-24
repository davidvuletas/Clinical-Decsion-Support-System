package sbnz.cdss.model.dto;

import sbnz.cdss.model.entity.Medical;

import java.util.List;

public class MedicalAndAlergens {
    private Medical m;
    private List<String> alergens;

    public MedicalAndAlergens(Medical m, List<String> alergic) {
        this.m = m;
        this.alergens = alergic;
    }

    public Medical getM() {
        return m;
    }

    public void setM(Medical m) {
        this.m = m;
    }

    public List<String> getAlergens() {
        return alergens;
    }

    public void setAlergens(List<String> alergens) {
        this.alergens = alergens;
    }
}
