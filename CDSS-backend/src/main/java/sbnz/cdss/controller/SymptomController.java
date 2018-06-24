package sbnz.cdss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbnz.cdss.model.dto.SymptomDto;
import sbnz.cdss.model.entity.Symptom;
import sbnz.cdss.service.SymptomService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @GetMapping
    public ResponseEntity<?> getAllSymptoms() {
        List<Symptom> symptoms = this.symptomService.getAllSymptoms();
        List<SymptomDto> symptomDtos = new ArrayList<>();
        for (Symptom s : symptoms) {
            symptomDtos.add(new SymptomDto(s.getId(), s.getDescription()));
        }

        return ResponseEntity.ok(symptomDtos);
    }

    @PostMapping
    public ResponseEntity<?> addSymptom(@RequestBody Symptom symptom) {
        return ResponseEntity.ok(this.symptomService.addNewSymptom(symptom));
    }
}
