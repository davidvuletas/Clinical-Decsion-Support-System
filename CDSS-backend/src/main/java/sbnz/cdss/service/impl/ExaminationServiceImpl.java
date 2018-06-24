package sbnz.cdss.service.impl;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Disease;
import sbnz.cdss.model.entity.DiseaseCategory;
import sbnz.cdss.model.entity.DiseaseSymptom;
import sbnz.cdss.model.entity.Examination;
import sbnz.cdss.repository.DiseaseRepository;
import sbnz.cdss.repository.ExaminationRepository;
import sbnz.cdss.service.DiseaseService;
import sbnz.cdss.service.ExaminationService;
import sbnz.cdss.service.UtilService;

import java.util.*;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;

    @Override
    public List<Examination> getAllExaminations() {
        return this.examinationRepository.findAll();
    }

    @Override
    public Examination addExamination(Examination examination) {
        return this.examinationRepository.save(examination);
    }

    @Override
    public void removeExamination(Examination examination) {
        this.examinationRepository.delete(examination);
    }

    @Override
    public void removeExamination(Long id) {
        Examination examination = this.examinationRepository.findExaminationById(id);
        this.examinationRepository.delete(examination);
    }

    @Override
    public Examination updateExamination(Examination examination) {
        return this.examinationRepository.save(examination);
    }
}
