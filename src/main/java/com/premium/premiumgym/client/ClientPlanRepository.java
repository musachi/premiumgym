package com.premium.premiumgym.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientPlanRepository extends JpaRepository<ClientPlan, Long> {
    public ClientPlan findByClientAndPlan(Long clientId, Long PlanId);

    public List<Client> findClientsByPlan(Long planId);
}