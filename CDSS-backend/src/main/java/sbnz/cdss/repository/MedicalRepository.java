package sbnz.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sbnz.cdss.model.entity.CategoryOfMedical;
import sbnz.cdss.model.entity.Medical;

import java.util.List;

@Repository
public interface MedicalRepository extends JpaRepository<Medical, Long> {

    List<Medical> findMedicalsByCategory(CategoryOfMedical category);

    Medical findMedicalByName(String name);

    List<Medical> findMedicalsByIngredients(String ingredient);
}
