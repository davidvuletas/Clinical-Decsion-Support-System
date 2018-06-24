package sbnz.cdss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbnz.cdss.model.dto.*;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.model.entity.DiseaseSymptom;
import sbnz.cdss.model.entity.Symptom;
import sbnz.cdss.service.DiseaseService;
import sbnz.cdss.service.SymptomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/diseases")
public class DiseaseController {


    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private SymptomService symptomService;

    @PostMapping("/find-all/linked-by-symptoms")
    public ResponseEntity<?> getAllLinkedDiseases(@RequestBody SymptomsForSearch symptomsForSearch) {
        Map<Disease, Integer> diseaseMap = this.diseaseService.getAllDiseaseLinkedBySymptoms(symptomsForSearch.getSymptoms());
        List<DiseaseNumOfInclude> diseaseList = new ArrayList<>();
        for (Disease d : diseaseMap.keySet()) {
            Integer value = diseaseMap.get(d);
            diseaseList.add(new DiseaseNumOfInclude(d.getName(), value));
        }
        diseaseList.sort((o1, o2) -> o2.getNumber() - o1.getNumber());
        return ResponseEntity.ok(diseaseList);
    }

    @PostMapping("/find-all/symptoms/by-disease")
    public ResponseEntity<?> getAllSymptomsByDisease(@RequestBody DiseaseQueryDto diseaseQueryDto) {
        Map<String, Boolean> diseaseWithSymptoms = this.diseaseService.getDiseaseWithSymptoms(diseaseQueryDto.getDiseaseName());
        List<SymptomWithSpecificVal> symptomWithSpecificVals = new ArrayList<>();
        for (String name : diseaseWithSymptoms.keySet()) {
            boolean isgeneral = diseaseWithSymptoms.get(name);
            symptomWithSpecificVals.add(new SymptomWithSpecificVal(name, isgeneral));
        }
        DiseaseQueryDto queryDto = new DiseaseQueryDto(diseaseQueryDto.getDiseaseName(), symptomWithSpecificVals);
        return ResponseEntity.ok(queryDto);
    }

    @GetMapping
    public ResponseEntity<?> getAllDiseases() {
        List<Disease> allDiseases = this.diseaseService.getAllDiseases();
        List<DiseaseDto> diseaseDtos = new ArrayList<>();
        for (Disease d : allDiseases) {
            diseaseDtos.add(d.toDto());
        }

        return ResponseEntity.ok(diseaseDtos);
    }


    @PostMapping
    public ResponseEntity<?> addDisease(@RequestBody DiseaseDto diseaseDto) {
        Disease disease = new Disease();
        disease.setName(diseaseDto.getName());
        disease.setSymptoms(new ArrayList<>());
        Disease ds = this.diseaseService.addDisease(disease);
        for (SymptomDto symptomDto : diseaseDto.getSymptoms()) {
            Symptom s = this.symptomService.getSymptomByName(symptomDto.getDescription());
            ds.getSymptoms().add(new DiseaseSymptom(ds, s, false));
        }
        ds = this.diseaseService.addDisease(ds);
        return ResponseEntity.ok(ds.toDto());
    }
}
