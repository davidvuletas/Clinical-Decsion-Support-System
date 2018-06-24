package sbnz.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sbnz.cdss.model.entity.Patient;
import sbnz.cdss.model.entity.User;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findPatientByHealthCardNumber(String cardNumber);
    Patient findPatientById(Long id);
}
