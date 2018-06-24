package sbnz.cdss.service.impl;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.model.entity.DiseaseSymptom;
import sbnz.cdss.model.entity.Symptom;
import sbnz.cdss.repository.SymptomRepository;
import sbnz.cdss.service.DiseaseService;
import sbnz.cdss.service.SymptomService;
import sbnz.cdss.service.UtilService;

import java.util.List;

@Service
public class SymptomServiceImpl implements SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private UtilService utilService;

    @Override
    public List<Symptom> getAllSymptoms() {
        return this.symptomRepository.findAll();
    }

    @Override
    public Symptom getSymptomById(Long id) {
        return this.symptomRepository.getOne(id);
    }

    @Override
    public Symptom getSymptomByName(String name) {
        return this.symptomRepository.getSymptomByDescription(name);
    }

    @Override
    public Symptom addNewSymptom(Symptom symptom) {
        return this.symptomRepository.save(symptom);
    }

    @Override
    public Symptom updateSymptom(Symptom symptom) {
        return this.symptomRepository.save(symptom);
    }

    @Override
    public Disease addNewSymptomToDisease(Symptom symptom, Disease disease, boolean general) {
        Disease inSession = this.diseaseService.findById(disease.getId());
        Symptom s = symptomRepository.save(symptom);
        DiseaseSymptom ds = new DiseaseSymptom();
        ds.setSymptom(s);
        ds.setDisease(inSession);
        ds.setGeneral(general);
        inSession.getSymptoms().add(ds);
        return this.diseaseService.updateDisease(inSession);

    }

    @Override
    public Disease removeSymptomFromDisease(Disease disease) {
        return null;
    }

    @Override
    public void deleteSymptom(Symptom symptom) {
        this.symptomRepository.delete(symptom);
    }
}
