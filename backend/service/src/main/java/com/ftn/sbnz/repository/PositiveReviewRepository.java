package com.ftn.sbnz.repository;

import com.ftn.sbnz.model.user.PositiveReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositiveReviewRepository extends JpaRepository<PositiveReview, Long> {
}
