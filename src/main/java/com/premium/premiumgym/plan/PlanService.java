package com.premium.premiumgym.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {
    @Autowired
    public PlanRepository planRepository;

    public Plan create(Plan plan)
    {
        return this.planRepository.save(plan);
    }

    public List<Plan> findAll()
    {
        return this.planRepository.findAll();
    }

    public Plan findById(Long id)
    {
        return this.planRepository.findById(id).get();
    }

    public Plan update(Long id, Plan planDetails)
    {
        Plan plan = this.findById(id);
        plan.copy(planDetails);

        return this.planRepository.save(plan);
    }

    public void delete(Long id)
    {
        this.planRepository.deleteById(id);
    }

}


