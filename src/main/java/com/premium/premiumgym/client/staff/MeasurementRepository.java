package com.premium.premiumgym.client.staff;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long>{
    public List<Measurement> findByClient(Long id);
}