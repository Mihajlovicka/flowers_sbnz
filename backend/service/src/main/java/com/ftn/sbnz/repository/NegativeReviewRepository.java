package com.ftn.sbnz.repository;

import com.ftn.sbnz.model.user.NegativeReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NegativeReviewRepository extends JpaRepository<NegativeReview, Long> {
}
