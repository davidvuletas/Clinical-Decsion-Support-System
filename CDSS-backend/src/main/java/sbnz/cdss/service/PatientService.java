package sbnz.cdss.service;

import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.model.entity.User;

import java.util.List;

@Service
public interface PatientService {
    Patient findPatientByCardNumber(String cardNumber);
    List<Patient> getAllPatients();
    Patient addPatient(Patient patient);
    void removePatient(Patient patient);
    void removePatient(Long id);
    Patient updatePatient(Patient patient);
}
