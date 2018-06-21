package sbnz.cdss.service;

import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.model.entity.User;

@Service
public interface PatientService {
    Patient findPatientByCardNumber(String cardNumber);
}
