package sbnz.cdss.service;

import org.springframework.stereotype.Service;
import sbnz.cdss.model.dto.MedicalAndAlergens;
import sbnz.cdss.model.dto.PatientDto;
import sbnz.cdss.model.entity.Medical;

import java.util.List;

@Service
public interface MedicalService {

    List<Medical> getAllMedicals();
    List<MedicalAndAlergens> checkAllergens(List<Medical> medicals, PatientDto patientDto);
    Medical findById(Long id);
    Medical addMedical(Medical medical);
    Medical updateMedical(Medical medical);
    void removeMedical(Medical medical);
    void removeMedical(Long id);
}
