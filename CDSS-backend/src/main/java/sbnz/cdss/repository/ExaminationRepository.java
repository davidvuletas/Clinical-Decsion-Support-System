package sbnz.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sbnz.cdss.model.entity.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

    Examination findExaminationById(Long id);
}
