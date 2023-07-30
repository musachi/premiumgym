package com.premium.premiumgym.trainingday;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long>, JpaSpecificationExecutor<TrainingDay> {
    public List<TrainingDay> findByMicrosId(Long id);
}