package sbnz.cdss.service.impl;

import org.drools.core.common.DefaultFactHandle;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.model.entity.DiseaseCategory;
import sbnz.cdss.model.entity.DiseaseSymptom;
import sbnz.cdss.repository.DiseaseRepository;
import sbnz.cdss.service.DiseaseService;
import sbnz.cdss.service.UtilService;

import java.util.*;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private UtilService utilService;

    @Override
    public Disease addDisease(Disease disease) {
        Disease d = this.diseaseRepository.save(disease);
        for (KieSession ks : this.utilService.getAllSessions().values()) {
            ks.insert(d);
        }
        return d;
    }

    @Override
    public List<Disease> getAllDiseases() {
        return this.diseaseRepository.findAll();
    }

    @Override
    public Disease getDiseaseByName(String name) {
        return this.diseaseRepository.getDiseaseByName(name);
    }


    @Override
    public List<Disease> getAllDiseasesByCategory(DiseaseCategory category) {
        return this.diseaseRepository.getDiseasesByDiseaseCategory(category);
    }


    @Override
    public Map getAllDiseaseLinkedBySymptoms(List<String> symptoms) {
        KieSession kieSession = this.utilService.getSessionForUser();
        Map resultMap = new HashMap();
        QueryResults results = null;
        results = kieSession.getQueryResults("getAllDiseaseLinkedBySymptoms", symptoms);
        for (QueryResultsRow res : results) {
            Map<Disease, Integer> result = (Map<Disease, Integer>) res.get("d");
            if (!result.isEmpty()) {
                for (Disease disease : result.keySet()) {
                    Integer value = result.get(disease);
                    resultMap.put(disease, value);
                }
            }
        }
        return resultMap;
    }

    @Override
    public Map getDiseaseWithSymptoms(String nameOfDisease) {
        KieSession kieSession = this.utilService.getSessionForUser();
        Map<String, Boolean> resultMap = new HashMap();
        QueryResults results = null;
        results = kieSession.getQueryResults("getDiseaseWithSymptoms", nameOfDisease);
        for (QueryResultsRow res : results) {
            List<DiseaseSymptom> general = (List<DiseaseSymptom>) res.get("$sg");
            List<DiseaseSymptom> nonGeneral = (List<DiseaseSymptom>) res.get("$sng");

            if (!general.isEmpty()) {
                for (DiseaseSymptom ds : general) {
                    resultMap.put(ds.getSymptom().getDescription(), true);
                }
            }
            for (DiseaseSymptom ds : nonGeneral) {
                resultMap.put(ds.getSymptom().getDescription(), false);
            }
        }
        resultMap = sortByValue(resultMap);
        return resultMap;
    }


    @Override
    public Disease updateDisease(Disease disease) {
        Disease inSession = this.diseaseRepository.findDiseaseById(disease.getId());
        Disease updatedDisease = this.diseaseRepository.save(disease);
        for (KieSession ks : this.utilService.getAllSessions().values()) {
            for (FactHandle factHandle : ks.getFactHandles()) {
                Object obj = ((DefaultFactHandle) factHandle).getObject();
                if (obj.getClass().equals(Disease.class)) {
                    if (((Disease) obj).getId().equals(disease.getId())) {
                        ks.update(factHandle, updatedDisease);
                        return updatedDisease;
                    }
                }
            }
        }
        return updatedDisease;
    }

    @Override
    public void removeDisease(Disease disease) {
        this.diseaseRepository.delete(disease);
        for (KieSession ks : this.utilService.getAllSessions().values()) {
            for (FactHandle factHandle : ks.getFactHandles()) {
                Object obj = ((DefaultFactHandle) factHandle).getObject();
                if (obj.getClass().equals(Disease.class)) {
                    if (((Disease) obj).getId().equals(disease.getId())) {
                        ks.delete(factHandle);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void removeDisease(Long id) {
        Disease disease = this.diseaseRepository.findDiseaseById(id);
        this.diseaseRepository.delete(disease);
        for (KieSession ks : this.utilService.getAllSessions().values()) {
            for (FactHandle factHandle : ks.getFactHandles()) {
                Object obj = ((DefaultFactHandle) factHandle).getObject();
                if (obj.getClass().equals(Disease.class)) {
                    if (((Disease) obj).getId().equals(disease.getId())) {
                        ks.delete(factHandle);
                    }
                }
            }
        }
    }

    @Override
    public Disease findById(Long id) {
        return this.diseaseRepository.findDiseaseById(id);
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
