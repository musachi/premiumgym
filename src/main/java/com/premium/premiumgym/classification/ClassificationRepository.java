package com.premium.premiumgym.classification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    //public List<Classification> findByClassificationTypeId(Long id);
}
