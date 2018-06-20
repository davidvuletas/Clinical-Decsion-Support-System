package sbnz.cdss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Symptom;
import sbnz.cdss.repository.SymptomRepository;
import sbnz.cdss.service.SymptomService;

import java.util.List;

@Service
public class SymptomServiceImpl implements SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    @Override
    public List<Symptom> getAllSymptoms() {
        List<Symptom> symptoms = this.symptomRepository.findAll();
        return symptoms;
    }

    @Override
    public Symptom getSymptomById(Long id) {
        Symptom symptom = this.symptomRepository.getOne(id);
        return symptom;
    }

    @Override
    public Symptom getSymptomByName(String name) {
        Symptom symptom = this.symptomRepository.getSymptomByDescription(name);
        return symptom;
    }

    @Override
    public Symptom addNewSymptom(Symptom symptom) {
        Symptom s = this.symptomRepository.save(symptom);
        return s;
    }

    @Override
    public void deleteSymptom(Symptom symptom) {
        this.symptomRepository.delete(symptom);
    }
}
