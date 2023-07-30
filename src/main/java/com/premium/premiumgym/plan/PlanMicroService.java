package com.premium.premiumgym.plan;

import com.premium.premiumgym.micro.Micro;
import com.premium.premiumgym.micro.MicroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanMicroService {

    @Autowired
    public PlanRepository planRepository;

    @Autowired
    public MicroRepository microRepository;

    @Autowired
    public PlanMicroRepository planMicroRepository;

    public List<Micro> findMicrosByPlanId(Long planId)
    {
        //TODO review an check if works ok, change it how it was before
        return this.planMicroRepository.findMicrosByPlanOrderByExecutionOrder(planId);
    }

    public void addMicroToPlan(PlanMicroDto planMicroDto)
    {
        Plan plan = this.planRepository.findById(planMicroDto.getPlanId()).get();
        Micro micro = this.microRepository.findById(planMicroDto.getMicroId()).get();

        PlanMicro planMicro = new PlanMicro();
        planMicro.setExecutionOrder(planMicroDto.getExecutionOrder());
        planMicro.setPlan(plan);
        planMicro.setMicro(micro);

        plan.addMicro(planMicro);
        micro.addPlan(planMicro);

        this.planRepository.save(plan);
        this.microRepository.save(micro);
    }

    public void removeMicroFromPlan(Long planId, Long microId)
    {
        Plan plan = this.planRepository.findById(planId).get();
        Micro micro = this.microRepository.findById(microId).get();

        PlanMicro planMicro = new PlanMicro();
        planMicro.setPlan(plan);
        planMicro.setMicro(micro);

        plan.removeMicro(planMicro);
        micro.removePlan(planMicro);

        this.planRepository.save(plan);
        this.microRepository.save(micro);
    }
}
