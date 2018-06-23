package sbnz.cdss.service.impl;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.service.ReportService;

import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private Map<String,KieSession> sessions;

    @Override
    public List<Patient> getAllPatientsChronic() {
        KieSession kieSession = this.sessions.get("david");
        QueryResults results = null;
        results = kieSession.getQueryResults("getReportForChronicDisease", 1000 * 60 * 60 * 24);
        for (QueryResultsRow res: results) {
            for(Patient p: (List<Patient>)res.get("patients")){
                System.out.println(p);
            }

        }
        return new ArrayList<>();
    }


}
