package sbnz.cdss;

import org.drools.core.time.SessionPseudoClock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.model.monitoring.HeartBeatEvent;
import sbnz.cdss.model.monitoring.OxygenEvent;
import sbnz.cdss.model.monitoring.UrinatingEvent;
import sbnz.cdss.service.PatientService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CdssApplicationTests {

    @Autowired
    private PatientService patientService;

    @Test
    public void testCEPConfigThroughKModuleXML() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("CDSS-rules","CDSS-rules-kjar", "0.0.1-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(3000);
        KieSession ksession = kContainer.newKieSession("cepConfigKsessionPseudoClock");
        runPseudoClock(ksession);
    }

    public void runPseudoClock(KieSession ksession) {
        SessionPseudoClock clock = ksession.getSessionClock();
        List<Patient>patients = this.patientService.getAllPatients();
        for (Patient p: patients) {
            ksession.insert(p);
        }


        /*OxygenEvent oxygenEvent = new OxygenEvent(50,1L);
        ksession.insert(oxygenEvent);
        clock.advanceTime(18,TimeUnit.MINUTES);
        ksession.fireAllRules();*/

        /*for(int i=0;i<26;i++) {
            HeartBeatEvent heartBeatEvent = new HeartBeatEvent(1L);
            ksession.insert(heartBeatEvent);
        }
        clock.advanceTime(9,TimeUnit.SECONDS);
        ksession.fireAllRules();
        */

        int count_fired = 0;
        UrinatingEvent urinatingEvent = new UrinatingEvent(50,1L);
        clock.advanceTime(11,TimeUnit.SECONDS);
        count_fired += ksession.fireAllRules();
        assertThat(count_fired,equalTo(0));
        clock.advanceTime(11,TimeUnit.HOURS);
        count_fired += ksession.fireAllRules();
        assertThat(count_fired,equalTo(0));
        for(int i=0;i<12;i++) {
            ksession.insert(new HeartBeatEvent(1L));
            clock.advanceTime(800,TimeUnit.MILLISECONDS);
            count_fired += ksession.fireAllRules();
        }
        assertThat(count_fired,equalTo(3));
    }


}
