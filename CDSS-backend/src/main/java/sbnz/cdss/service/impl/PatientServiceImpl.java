package sbnz.cdss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.model.entity.Role;
import sbnz.cdss.model.entity.User;
import sbnz.cdss.repository.PatientRepository;
import sbnz.cdss.repository.UserRepository;
import sbnz.cdss.service.PatientService;
import sbnz.cdss.service.UserService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient findPatientByCardNumber(String cardNumber) {
        return this.patientRepository.findPatientByHealthCardNumber(cardNumber);
    }

    @Override
    public List<Patient> getAllPatients() {
        return this.patientRepository.findAll();
    }
}
