package com.ftn.sbnz.repository;

import com.ftn.sbnz.model.back2.SubDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubDiseaseRepository extends JpaRepository<SubDisease, Long> {
}
