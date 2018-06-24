package sbnz.cdss.service.impl;

import org.drools.core.common.DefaultFactHandle;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.model.entity.User;
import sbnz.cdss.repository.PatientRepository;
import sbnz.cdss.service.PatientService;
import sbnz.cdss.service.UtilService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    private UtilService utilService;

    @Override
    public Patient findPatientByCardNumber(String cardNumber) {
        return this.patientRepository.findPatientByHealthCardNumber(cardNumber);
    }

    @Override
    public List<Patient> getAllPatients() {
        return this.patientRepository.findAll();
    }

    @Override
    public Patient addPatient(Patient patient) {
        this.patientRepository.save(patient);
        for (KieSession ks : this.utilService.getAllSessions().values()) {
            ks.insert(patient);
        }
        return patient;
    }

    @Override
    public void removePatient(Patient patient) {
        for (KieSession ks : this.utilService.getAllSessions().values()) {
            for(FactHandle factHandle: ks.getFactHandles()) {
                Object obj =  ((DefaultFactHandle)factHandle).getObject();
                if(obj.getClass().equals(Patient.class)) {
                    if(((Patient)obj).getId().equals(patient.getId())){
                        ks.delete(factHandle);
                    }
                }
            }
        }
        this.patientRepository.delete(patient);
    }

    @Override
    public void removePatient(Long id) {
        Patient patient = this.patientRepository.findPatientById(id);
        for (KieSession ks : this.utilService.getAllSessions().values()) {
            for(FactHandle factHandle: ks.getFactHandles()) {
                Object obj =  ((DefaultFactHandle)factHandle).getObject();
                if(obj.getClass().equals(Patient.class)) {
                    if(((Patient)obj).getId().equals(patient.getId())){
                        ks.delete(factHandle);
                        break;
                    }
                }
            }
        }
        this.patientRepository.delete(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Patient inSession = this.patientRepository.findPatientById(patient.getId());
        Patient newPatient = this.patientRepository.save(patient);
        for (KieSession ks : this.utilService.getAllSessions().values()) {
            for(FactHandle factHandle: ks.getFactHandles()) {
                Object obj =  ((DefaultFactHandle)factHandle).getObject();
                if(obj.getClass().equals(Patient.class)) {
                    if(((Patient)obj).getId().equals(inSession.getId())){
                        ks.update(factHandle,newPatient);
                        break;
                    }
                }
            }
        }
        return newPatient;
    }
}
