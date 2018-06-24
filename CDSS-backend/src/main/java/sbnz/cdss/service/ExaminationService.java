package sbnz.cdss.service;

import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Examination;
import sbnz.cdss.model.entity.Patient;

import java.util.List;

@Service
public interface ExaminationService {
    List<Examination> getAllExaminations();
    Examination addExamination(Examination examination);
    void removeExamination(Examination examination);
    void removeExamination(Long id);
    Examination updateExamination(Examination examination);
}
