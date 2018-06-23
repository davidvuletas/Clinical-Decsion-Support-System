package sbnz.cdss.service;

import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Patient;

import java.util.List;

@Service
public interface ReportService {
    List<Patient> getAllPatientsChronic();
}
