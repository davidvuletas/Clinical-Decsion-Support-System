package sbnz.cdss.service;

import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.DisaeseCategory;
import sbnz.cdss.model.entity.Disease;

import java.util.List;

@Service
public interface DiseaseService {

    Disease addNewDisease(Disease disease);

    List<Disease> getAllDiseases();

    Disease getDiseaseByName(String name);

    List<Disease> getAllDiseasesByCategory(DisaeseCategory category);

    void deleteDisease(Disease disease);
}
