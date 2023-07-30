package com.premium.premiumgym.client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientExerciseExecutionRepository extends JpaRepository<ClientExerciseExecution, Long> {
    public ClientExerciseExecution findByClientAndExerciseExecution(Long clientId, Long exerciseExecutionId);
}