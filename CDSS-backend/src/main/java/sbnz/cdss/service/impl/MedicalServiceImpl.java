package sbnz.cdss.service.impl;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.dto.MedicalAndAlergens;
import sbnz.cdss.model.dto.PatientDto;
import sbnz.cdss.model.entity.Medical;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.repository.MedicalRepository;
import sbnz.cdss.service.MedicalService;
import sbnz.cdss.service.PatientService;
import sbnz.cdss.service.UtilService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalServiceImpl implements MedicalService {

    @Autowired
    private MedicalRepository medicalRepository;

    @Autowired
    private UtilService utilService;

    @Autowired
    private PatientService patientService;


    @Override
    public List<Medical> getAllMedicals() {
        return this.medicalRepository.findAll();
    }

    @Override
    public List<MedicalAndAlergens> checkAllergens(List<Medical> medicals, PatientDto patientDto) {
        Patient p = patientService.findPatientByCardNumber(patientDto.getCardNumber());
        KieSession kieSession = this.utilService.getSessionForUser();
        List<MedicalAndAlergens> medicalAndAlergens = new ArrayList<>();
        QueryResults results = null;
        for (Medical m : medicals) {
            results = kieSession.getQueryResults("checkIfAllergic", new Object[]{m, p.getAllergens()});
            for (QueryResultsRow qr : results) {
                if (!((List<String>) qr.get("alergic")).isEmpty())
                    medicalAndAlergens.add(new MedicalAndAlergens(m, (List<String>) qr.get("alergic")));
            }
        }
        return medicalAndAlergens;
    }

    @Override
    public Medical findById(Long id) {
        return this.medicalRepository.findMedicalById(id);
    }

    @Override
    public Medical addMedical(Medical medical) {
        return this.medicalRepository.save(medical);
    }

    @Override
    public Medical updateMedical(Medical medical) {
        return this.medicalRepository.save(medical);
    }

    @Override
    public void removeMedical(Medical medical) {
        this.medicalRepository.delete(medical);
    }

    @Override
    public void removeMedical(Long id) {
        Medical medical = this.medicalRepository.findMedicalById(id);
        this.medicalRepository.delete(medical);
    }
}
