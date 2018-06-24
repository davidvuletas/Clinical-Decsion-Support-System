package sbnz.cdss.controller;

import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbnz.cdss.model.dto.MedicalAndAlergens;
import sbnz.cdss.model.dto.PatientAndMedicals;
import sbnz.cdss.model.dto.PatientDto;
import sbnz.cdss.model.dto.SymptomsForSearch;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.service.MedicalService;
import sbnz.cdss.service.PatientService;
import sbnz.cdss.service.ReportService;
import sbnz.cdss.service.UtilService;
import sbnz.cdss.service.impl.DebugAgendaEventListener;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/reasoner")
public class ReasonerController {

    @Autowired
    private UtilService utilService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private MedicalService medicalService;


    @PostMapping("/find-disease/priority")
    public ResponseEntity<?> findDiseaseBySymptomsWithPriority(@RequestBody SymptomsForSearch symptomsForSearch) {
        Patient patient = this.patientService.findPatientByCardNumber(symptomsForSearch.getPatientDto().getCardNumber());
        symptomsForSearch.setPatient(patient);
        KieSession kieSession = this.utilService.getSessionForUser();
        kieSession.getAgenda().getAgendaGroup("priority-symptoms").setFocus();
        kieSession.insert(symptomsForSearch);
        kieSession.fireAllRules(1);
        AgendaEventListener listener = (AgendaEventListener) kieSession.getAgendaEventListeners().toArray()[0];
        int len = ((DebugAgendaEventListener) listener).getRulesFired().size();
        String disease = "";
        if (len > 0) {
            disease = new String(((DebugAgendaEventListener) listener).getRulesFired().get(len - 1));
            ((DebugAgendaEventListener) listener).reset();
        }

        return new ResponseEntity<>(disease, HttpStatus.ACCEPTED);
    }

    @GetMapping("/report/patients/chronic-disease")
    public ResponseEntity<?> getReportForPatientWithChronicDisease() {
        this.reportService.getAllPatientsChronic();
        return ResponseEntity.ok("");
    }

    @GetMapping("/report/patients/weakened-immune")
    public ResponseEntity<?> getReportForPatientWhichHaveWeaknedImmune() {
        this.reportService.getAllPatientsWeakned();
        return ResponseEntity.ok("");
    }

    @GetMapping("/report/patients/addicted")
    public ResponseEntity<?> getReportForPatientWhichAreAddicted() {
        this.reportService.getAllPatientsAddicted();
        return ResponseEntity.ok("");
    }


    @PostMapping("/patient/allergens")
    public ResponseEntity<?> isAllergic(@RequestBody PatientAndMedicals patientAndMedicals) {
        List<MedicalAndAlergens> medicalAndAlergens = this.medicalService.
                checkAllergens(patientAndMedicals.getMedicals(), patientAndMedicals.getPatientDto());
        return ResponseEntity.ok(medicalAndAlergens);

    }

}
