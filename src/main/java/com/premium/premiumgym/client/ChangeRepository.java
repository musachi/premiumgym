package com.premium.premiumgym.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangeRepository extends JpaRepository<Change, Long> {
    public List<Change> findByClient(Long clientId);
}