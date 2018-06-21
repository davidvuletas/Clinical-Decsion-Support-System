package sbnz.cdss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.DiseaseCategory;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.repository.DiseaseRepository;
import sbnz.cdss.service.DiseaseService;

import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public Disease addNewDisease(Disease disease) {
        Disease d = this.diseaseRepository.save(disease);
        return d;
    }

    @Override
    public List<Disease> getAllDiseases() {
        List<Disease> diseases =  this.diseaseRepository.findAll();
        return diseases;
    }

    @Override
    public Disease getDiseaseByName(String name) {
        Disease disease = this.diseaseRepository.getDiseaseByName(name);
        return disease;
    }

    @Override
    public List<Disease> getAllDiseasesByCategory(DiseaseCategory category) {
        List<Disease> diseases = this.diseaseRepository.getDiseasesByDisaeseCategory(category);
        return diseases;
    }

    @Override
    public void deleteDisease(Disease disease) {
        this.diseaseRepository.delete(disease);
    }

    @Override
    public List<Disease> getAllDiseaseLinkedBySymptoms(List<String> symptoms) {
        return null;
    }
}
