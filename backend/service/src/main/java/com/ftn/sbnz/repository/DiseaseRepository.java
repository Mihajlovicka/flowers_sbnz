package com.ftn.sbnz.repository;

import com.ftn.sbnz.model.back2.Disease;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    List<Disease> findDiseaseByTopIsTrue();
}
