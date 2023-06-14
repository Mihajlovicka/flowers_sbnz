package com.ftn.sbnz.repository;

import com.ftn.sbnz.model.back2.DiseaseSymptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseSymptomRepository extends JpaRepository<DiseaseSymptom, Long> {
}
