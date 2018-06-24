package sbnz.cdss.service;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface UtilService {
    void createKieSession(String username);
    void removeKieSession();
    HashMap<String, KieSession> getAllSessions();
    String getLoggedUser();
    KieSession getSessionForUser();
    void addLoggedUserToSession(String username);
    void removeLoggedUserFromSession();
}
