package sbnz.cdss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sbnz.cdss.model.dto.PatientDto;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.service.PatientService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<?> getAllPatients() {
        List<Patient> patientList = this.patientService.getAllPatients();
        List<PatientDto> patientDtos = new ArrayList<>();
        for (Patient p : patientList) {
            patientDtos.add(new PatientDto(p.getFirstname(),p.getLastname(),p.getId(),p.getHealthCardNumber(),p.getAllergens(),p.getFirstname() + " " + p.getLastname()));
        }

        return ResponseEntity.ok(patientDtos);
    }
}
