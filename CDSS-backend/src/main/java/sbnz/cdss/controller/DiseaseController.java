package sbnz.cdss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sbnz.cdss.model.dto.SymptomsForSearch;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.service.DiseaseService;

import java.util.List;

@RestController
@RequestMapping("/api/diseases")
public class DiseaseController {


    @Autowired
    private DiseaseService diseaseService;

    @PostMapping("/find-all/linked")
    public ResponseEntity<?> getAllLinkedDiseases(@RequestBody SymptomsForSearch symptomsForSearch) {
        List<Disease> diseaseList = this.diseaseService.getAllDiseaseLinkedBySymptoms(symptomsForSearch.getSymptoms());
        return ResponseEntity.ok(diseaseList);
    }
}
