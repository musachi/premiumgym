package com.premium.premiumgym.plan;

import com.premium.premiumgym.micro.Micro;
import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ConstantValues.PLANS)
public class PlanController {

    @Autowired
    public PlanService planService;

    @Autowired
    public PlanMicroService planMicroService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Plan create(@RequestBody Plan plan)
    {
        return this.planService.create(plan);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Plan> findAll()
    {
        return this.planService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Plan getPlanById(@PathVariable Long id)
    {
        return  this.planService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Plan update(@PathVariable Long id, @RequestBody Plan planDetails)
    {
        return this.planService.update(id, planDetails);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        this.delete(id);
    }


    //Relationsihps

    @RequestMapping(value = "/{id}" + ConstantValues.MICROS, method = RequestMethod.GET)
    public List<Micro> findMicrosByPlanId(@PathVariable Long id)
    {
        return this.planMicroService.findMicrosByPlanId(id);

    }

    @RequestMapping(value = "/{id}" + ConstantValues.MICROS + "/{microId}", method = RequestMethod.POST)
    public void addMicroToPlan(@PathVariable Long id, @PathVariable Long microId, @RequestBody Integer executionOrder)
    {
        PlanMicroDto planMicroDto = new PlanMicroDto();
        planMicroDto.setPlanId(id);
        planMicroDto.setMicroId(microId);
        planMicroDto.setExecutionOrder(executionOrder);

        this.planMicroService.addMicroToPlan(new PlanMicroDto());
    }

    @RequestMapping(value = "/{id}" + ConstantValues.MICROS + "/{microId}", method = RequestMethod.DELETE)
    public void deleteMicroFromPlan(@PathVariable Long id, @PathVariable Long microId)
    {
        this.planMicroService.removeMicroFromPlan(id, microId);
    }
}
