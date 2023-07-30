package com.premium.premiumgym.plan;

import com.premium.premiumgym.micro.Micro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanMicroRepository extends JpaRepository<PlanMicro, Long> {
    public List<Micro> findMicrosByPlanOrderByExecutionOrder(Long planId);
}