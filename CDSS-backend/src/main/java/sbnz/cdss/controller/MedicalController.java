package sbnz.cdss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbnz.cdss.model.entity.Medical;
import sbnz.cdss.service.MedicalService;

import java.util.List;

@RestController
@RequestMapping("api/medicals")
public class MedicalController {

    @Autowired
    private MedicalService medicalService;

    @GetMapping
    public ResponseEntity<?> getAllMedicals() {
        List<Medical> medicals = this.medicalService.getAllMedicals();
        return new ResponseEntity<>(medicals, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> addMedical(@RequestBody Medical medical) {
        Medical m = this.medicalService.addMedical(medical);
        return ResponseEntity.ok(m);
    }


}
