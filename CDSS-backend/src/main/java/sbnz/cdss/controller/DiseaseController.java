package sbnz.cdss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbnz.cdss.model.dto.*;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.service.DiseaseService;

import java.util.*;

@RestController
@RequestMapping("/api/diseases")
public class DiseaseController {


    @Autowired
    private DiseaseService diseaseService;

    @PostMapping("/find-all/linked-by-symptoms")
    public ResponseEntity<?> getAllLinkedDiseases(@RequestBody SymptomsForSearch symptomsForSearch) {
        Map<Disease,Integer> diseaseMap = this.diseaseService.getAllDiseaseLinkedBySymptoms(symptomsForSearch.getSymptoms());
        List<DiseaseNumOfInclude> diseaseList = new ArrayList<>();
        for (Disease d:diseaseMap.keySet()) {
            Integer value = diseaseMap.get(d);
            diseaseList.add(new DiseaseNumOfInclude(d.getName(),value));
        }
        diseaseList.sort((o1, o2) -> o2.getNumber() - o1.getNumber());
        return ResponseEntity.ok(diseaseList);
    }

    @PostMapping("/find-all/symptoms/by-disease")
    public ResponseEntity<?> getAllSymptomsByDisease(@RequestBody DiseaseQueryDto diseaseQueryDto) {
        Map<String, Boolean> diseaseWithSymptoms = this.diseaseService.getDiseaseWithSymptoms(diseaseQueryDto.getDiseaseName());
        List<SymptomWithSpecificVal> symptomWithSpecificVals = new ArrayList<>();
        for (String name: diseaseWithSymptoms.keySet()) {
            boolean isgeneral = diseaseWithSymptoms.get(name);
            symptomWithSpecificVals.add(new SymptomWithSpecificVal(name,isgeneral));
        }
        DiseaseQueryDto queryDto = new DiseaseQueryDto(diseaseQueryDto.getDiseaseName(),symptomWithSpecificVals);
        return ResponseEntity.ok(queryDto);
    }

    @GetMapping
    public ResponseEntity<?> getAllDiseases() {
        List<Disease> allDiseases = this.diseaseService.getAllDiseases();
        List<DiseaseDto> diseaseDtos = new ArrayList<>();
        for(Disease d: allDiseases){
            diseaseDtos.add(d.toDto());
        }

        return ResponseEntity.ok(diseaseDtos);
    }
}
