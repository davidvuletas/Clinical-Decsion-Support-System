package sbnz.cdss.service.impl;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.DiseaseCategory;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.model.entity.DiseaseSymptom;
import sbnz.cdss.model.entity.Symptom;
import sbnz.cdss.repository.DiseaseRepository;
import sbnz.cdss.service.DiseaseService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private HashMap<String,KieSession> sessions;

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
    public Map getAllDiseaseLinkedBySymptoms(List<String> symptoms) {
        KieSession kieSession = this.sessions.get("dr_tica");
        Map resultMap = new HashMap();
        QueryResults results = null;
        results = kieSession.getQueryResults("getAllDiseaseLinkedBySymptoms", symptoms);
        for (QueryResultsRow res: results) {
            Map<Disease,Integer> result = (Map<Disease, Integer>) res.get("d");
            if(!result.isEmpty())
            {
                for(Disease disease: result.keySet()) {
                    Integer value = result.get(disease);
                    resultMap.put(disease,value);
                }
            }
        }
        return resultMap;
    }

    @Override
    public Map getDiseaseWithSymptoms(String nameOfDisease) {
        KieSession kieSession = this.sessions.get("dr_tica");
        Map<String,Boolean> resultMap = new HashMap();
        QueryResults results = null;
        results = kieSession.getQueryResults("getDiseaseWithSymptoms", nameOfDisease);
        for (QueryResultsRow res: results) {
            List<DiseaseSymptom> general = (List<DiseaseSymptom>) res.get("$sg");
            List<DiseaseSymptom> nonGeneral = (List<DiseaseSymptom>) res.get("$sng");

            if(!general.isEmpty()) {
                for (DiseaseSymptom ds: general) {
                    resultMap.put(ds.getSymptom().getDescription(),true);
                }
            }
            for(DiseaseSymptom ds: nonGeneral) {
                resultMap.put(ds.getSymptom().getDescription(),false);
            }
        }
        resultMap = sortByValue(resultMap);
        return resultMap;
    }


    private static Map<String, Boolean> sortByValue(Map<String, Boolean> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Boolean>> list =
                new LinkedList<Map.Entry<String, Boolean>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Boolean>>() {
            public int compare(Map.Entry<String, Boolean> o1,
                               Map.Entry<String, Boolean> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Boolean> sortedMap = new LinkedHashMap<String, Boolean>();
        for (Map.Entry<String, Boolean> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }



        return sortedMap;
    }
}
