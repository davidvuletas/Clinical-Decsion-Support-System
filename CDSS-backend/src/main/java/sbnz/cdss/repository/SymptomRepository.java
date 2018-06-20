package sbnz.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sbnz.cdss.model.entity.Symptom;
import sbnz.cdss.model.entity.User;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom,Long> {

   Symptom getSymptomByDescription(String name);
}
