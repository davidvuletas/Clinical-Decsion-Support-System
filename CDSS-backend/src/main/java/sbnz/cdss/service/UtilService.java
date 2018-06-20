package sbnz.cdss.service;

import org.springframework.stereotype.Service;

@Service
public interface UtilService {
    void createKieSession(String username);
}
