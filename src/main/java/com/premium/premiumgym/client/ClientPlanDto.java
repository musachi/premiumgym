package com.premium.premiumgym.client;

import java.time.LocalDate;

public class ClientPlanDto {
    private Long clientId;
    private Long planId;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer executionOrder;

    private Integer dayStartWeek;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
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
}
