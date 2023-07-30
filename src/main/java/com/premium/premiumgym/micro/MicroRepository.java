package com.premium.premiumgym.micro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MicroRepository extends JpaRepository<Micro, Long>, JpaSpecificationExecutor<Micro> {
    public List<Micro> findMicrosByPlansId(Long planId); //TODO check if it is being used. Or DELETE
}