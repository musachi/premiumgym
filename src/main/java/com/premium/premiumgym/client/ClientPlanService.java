package com.premium.premiumgym.client;

import com.premium.premiumgym.plan.Plan;
import com.premium.premiumgym.plan.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientPlanService {

    @Autowired
    public ClientRepository clientRepository;

    @Autowired
    public PlanRepository planRepository;

    @Autowired
    public ClientPlanRepository clientPlanRepository;

    @Transactional
    public void addPlanToClient(ClientPlanDto clientPlanDto)
    {
        Client client = this.clientRepository.findById(clientPlanDto.getClientId()).get();
        Plan plan = this.planRepository.findById(clientPlanDto.getPlanId()).get();

        ClientPlan clientPlan = new ClientPlan();
        clientPlan.attrFromClientPlanDto(clientPlanDto);
        clientPlan.setClient(client);
        clientPlan.setPlan(plan);

        client.addPlan(clientPlan);
        plan.addClient(clientPlan);

        this.clientRepository.save(client);
        this.planRepository.save(plan);
    }

    public void removePlanToClient(Long clientId, Long planId)
    {
        Client client = this.clientRepository.findById(clientId).get();
        Plan plan = this.planRepository.findById(planId).get();

        ClientPlan clientPlan = this.clientPlanRepository.findByClientAndPlan(clientId, planId);
        this.clientPlanRepository.delete(clientPlan);
        clientPlan.setClient(client);
        clientPlan.setPlan(plan);

        client.removePlan(clientPlan);
        plan.removeClient(clientPlan);

        this.clientRepository.save(client);
        this.planRepository.save(plan);
    }

    public List<Client> findClientsByPlan(Long planId)
    {
        return this.clientPlanRepository.findClientsByPlan(planId);
    }

    public List<Plan> findPlansByClient(Long clientId)
    {
        return this.findPlansByClient(clientId);
    }
}