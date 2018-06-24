package sbnz.cdss.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.service.DiseaseService;
import sbnz.cdss.service.PatientService;
import sbnz.cdss.service.UtilService;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;

@Service
public class UtilServiceImpl implements UtilService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private HashMap<String, KieSession> sessions;

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ServletContext servletContext;


    @Override
    public void createKieSession(String username) {
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        kieSession.addEventListener(new DebugAgendaEventListener());
        List<Disease> diseases = this.diseaseService.getAllDiseases();
        for (Disease d : diseases) {
            kieSession.insert(d);
        }
        List<Patient> patients = this.patientService.getAllPatients();
        for (Patient p : patients) {
            kieSession.insert(p);
        }
        this.sessions.put(username, kieSession);
    }

    @Override
    public void removeKieSession() {
        this.sessions.remove(getLoggedUser());
    }

    @Override
    public HashMap<String, KieSession> getAllSessions() {
        return this.sessions;
    }

    @Override
    public String getLoggedUser() {
        return (String)servletContext.getAttribute("loggedUser");
    }

    @Override
    public KieSession getSessionForUser() {
        return this.sessions.get(getLoggedUser());
    }

    @Override
    public void addLoggedUserToSession(String username) {
        servletContext.setAttribute("loggedUser",username);
    }

    @Override
    public void removeLoggedUserFromSession() {
        servletContext.removeAttribute("loggedUser");
    }
}
