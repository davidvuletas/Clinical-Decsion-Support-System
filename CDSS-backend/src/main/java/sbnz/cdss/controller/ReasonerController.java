package sbnz.cdss.controller;

import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbnz.cdss.model.dto.PatientDto;
import sbnz.cdss.model.dto.SymptomsForSearch;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.service.PatientService;
import sbnz.cdss.service.ReportService;
import sbnz.cdss.service.impl.DebugAgendaEventListener;

import java.util.HashMap;

@RestController
@RequestMapping("api/reasoner")
public class ReasonerController {

    @Autowired
    private HashMap<String, KieSession> sessions;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ReportService reportService;

    @PostMapping("/find-disease/priority")
    public ResponseEntity<?> findDiseaseBySymptomsWithPriority(@RequestBody SymptomsForSearch symptomsForSearch) {
        Patient patient = this.patientService.findPatientByCardNumber(symptomsForSearch.getPatientDto().getCardNumber());
        symptomsForSearch.setPatient(patient);
        KieSession kieSession = this.sessions.get("dr_tica");
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

}
