package sbnz.cdss.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.GenericWebApplicationContext;
import sbnz.cdss.CdssApplication;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.service.DiseaseService;
import sbnz.cdss.service.UtilService;

import java.util.HashMap;
import java.util.List;

@Service
public class UtilServiceImpl implements UtilService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private HashMap<String,KieSession> sessions;

    @Autowired
    private DiseaseService diseaseService;

    @Override
    public void createKieSession(String username) {
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        kieSession.addEventListener(new DebugAgendaEventListener());
        List<Disease> diseases = this.diseaseService.getAllDiseases();
        for (Disease d:diseases) {
            kieSession.insert(d);
        }
        this.sessions.put(username,kieSession);
    }
}
