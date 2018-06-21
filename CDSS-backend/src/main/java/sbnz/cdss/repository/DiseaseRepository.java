package sbnz.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sbnz.cdss.model.entity.DiseaseCategory;
import sbnz.cdss.model.entity.Disease;

import java.util.List;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    Disease getDiseaseByName(String name);
    List<Disease> getDiseasesByDisaeseCategory(DiseaseCategory category);
}
