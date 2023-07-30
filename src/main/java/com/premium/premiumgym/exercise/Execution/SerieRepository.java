package com.premium.premiumgym.exercise.Execution;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    public List<Serie> findByExecutions(Execution execution);
}