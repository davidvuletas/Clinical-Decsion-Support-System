package sbnz.cdss.controller;

import org.drools.core.common.DefaultFactHandle;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbnz.cdss.model.dto.ExaminationDto;
import sbnz.cdss.model.dto.PatientDto;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.model.entity.Examination;
import sbnz.cdss.model.entity.Medical;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.service.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UtilService utilService;

    @Autowired
    private ExaminationService examinationService;

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private MedicalService medicalService;

    @GetMapping
    public ResponseEntity<?> getAllPatients() {
        List<Patient> patientList = this.patientService.getAllPatients();
        List<PatientDto> patientDtos = new ArrayList<>();
        for (Patient p : patientList) {
            patientDtos.add(new PatientDto(p.getFirstname(), p.getLastname(), p.getId(), p.getHealthCardNumber(), p.getAllergens(), p.getFirstname() + " " + p.getLastname()));
        }

        return ResponseEntity.ok(patientDtos);
    }

    @PostMapping
    public ResponseEntity<?> addPatient(@RequestBody PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setFirstname(patientDto.getName());
        patient.setLastname(patientDto.getLastname());
        patient.setHealthCardNumber(patientDto.getCardNumber());
        patient.setAllergens(patientDto.getAlergens());
        return ResponseEntity.ok().body(this.patientService.addPatient(patient));
    }
    @PostMapping("/{id}/examinations")
    public ResponseEntity<?> addNewExamination(@RequestBody ExaminationDto examinationDto, @PathVariable Long id) {
        Patient patient = this.patientService.findPatientByCardNumber(examinationDto.getPatient().getCardNumber());
        Disease disease = diseaseService.findById(examinationDto.getDisease().getId());
        List<Medical> medicals = new ArrayList<>();
        for(Medical m: examinationDto.getMedicals()) {
            Medical medical = this.medicalService.findById(m.getId());
            medicals.add(medical);
        }
        Examination examination = new Examination(new Date(), examinationDto.getDoctor(),
                disease, medicals);
        examination = this.examinationService.addExamination(examination);
        for (KieSession ks : this.utilService.getAllSessions().values()) {
            for(FactHandle factHandle: ks.getFactHandles()) {
                Object obj =  ((DefaultFactHandle)factHandle).getObject();
                if(obj.getClass().equals(Patient.class)) {
                    if(((Patient)obj).getId().equals(patient.getId())){
                        patient.getExaminations().add(examination);
                        ks.update(factHandle,patient);
                    }
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
