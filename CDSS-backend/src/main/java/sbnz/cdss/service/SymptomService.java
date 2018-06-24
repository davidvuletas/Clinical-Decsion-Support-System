package sbnz.cdss.service;

import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.model.entity.Symptom;

import java.util.List;

@Service
public interface SymptomService {

    List<Symptom> getAllSymptoms();
    Symptom getSymptomById(Long id);
    Symptom getSymptomByName(String name);
    Symptom addNewSymptom(Symptom symptom);
    Symptom updateSymptom(Symptom symptom);
    Disease addNewSymptomToDisease(Symptom symptom,Disease disease,boolean general);
    Disease removeSymptomFromDisease(Disease disease);
    void deleteSymptom(Symptom symptom);
}
