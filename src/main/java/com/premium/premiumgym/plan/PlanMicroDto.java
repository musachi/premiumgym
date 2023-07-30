package com.premium.premiumgym.plan;

public class PlanMicroDto {
    private Long planId;
    private Long microId;

    private Integer executionOrder;

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getMicroId() {
        return microId;
    }

    public void setMicroId(Long microId) {
        this.microId = microId;
    }

    public Integer getExecutionOrder() {
        return executionOrder;
    }

    public void setExecutionOrder(Integer executionOrder) {
        this.executionOrder = executionOrder;
    }
}
