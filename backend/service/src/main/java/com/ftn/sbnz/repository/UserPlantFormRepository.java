package com.ftn.sbnz.repository;

import com.ftn.sbnz.model.user.PlantCareUserForm;
import com.ftn.sbnz.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPlantFormRepository extends JpaRepository<PlantCareUserForm, Long> {
}
