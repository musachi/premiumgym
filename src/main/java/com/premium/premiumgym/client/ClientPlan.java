package com.premium.premiumgym.client;

import com.premium.premiumgym.plan.Plan;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"client_plan\"")
public class ClientPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_plan_id")
    private Long id;

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "\"client_id\"", nullable = false)
    private Client client;

    //private Shift shift;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer executionOrder;

    private Integer dayStartWeek;

    public void setId(Long id) {
        this.id = id;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getExecutionOrder() {
        return executionOrder;
    }

    public void setExecutionOrder(Integer executionOrder) {
        this.executionOrder = executionOrder;
    }

    public Integer getDayStartWeek() {
        return dayStartWeek;
    }

    public void setDayStartWeek(Integer dayStartWeek) {
        this.dayStartWeek = dayStartWeek;
    }

    public void attrFromClientPlanDto(ClientPlanDto clientPlanDto)
    {
        this.startDate = clientPlanDto.getStartDate();
        this.endDate = clientPlanDto.getEndDate();
        this.executionOrder = clientPlanDto.getExecutionOrder();
        this.dayStartWeek = clientPlanDto.getDayStartWeek();
    }
}