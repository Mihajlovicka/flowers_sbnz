package com.ftn.sbnz.repository;

import com.ftn.sbnz.model.back2.Symptom;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> {
    Optional<Symptom> findSymptomBySymptom(String symptom);
}
