package sbnz.cdss.service;

import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.DiseaseCategory;
import sbnz.cdss.model.entity.Disease;

import java.util.List;
import java.util.Map;

@Service
public interface DiseaseService {

    Disease addNewDisease(Disease disease);

    List<Disease> getAllDiseases();

    Disease getDiseaseByName(String name);

    List<Disease> getAllDiseasesByCategory(DiseaseCategory category);

    void deleteDisease(Disease disease);

    Map getAllDiseaseLinkedBySymptoms(List<String> symptoms);

    Map getDiseaseWithSymptoms(String nameOfDisease);
}
