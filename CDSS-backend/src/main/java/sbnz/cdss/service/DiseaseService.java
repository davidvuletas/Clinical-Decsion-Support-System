package sbnz.cdss.service;

import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.model.entity.DiseaseCategory;

import java.util.List;
import java.util.Map;

@Service
public interface DiseaseService {

    Disease addDisease(Disease disease);
    Disease updateDisease(Disease disease);
    void removeDisease(Disease disease);
    void removeDisease(Long id);
    Disease findById(Long id);
    List<Disease> getAllDiseases();
    Disease getDiseaseByName(String name);
    List<Disease> getAllDiseasesByCategory(DiseaseCategory category);
    Map getAllDiseaseLinkedBySymptoms(List<String> symptoms);
    Map getDiseaseWithSymptoms(String nameOfDisease);
}
