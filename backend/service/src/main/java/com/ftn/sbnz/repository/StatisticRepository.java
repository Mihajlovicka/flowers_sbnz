package com.ftn.sbnz.repository;

import com.ftn.sbnz.model.plant.Plant;
import com.ftn.sbnz.model.user.Statistic;
import com.ftn.sbnz.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
    Optional<Statistic> findStatisticByUserAndPlant(User user, Plant plant);

    List<Statistic> findByUser(User user);
}
