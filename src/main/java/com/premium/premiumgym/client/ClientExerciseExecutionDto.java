package com.premium.premiumgym.client;

import java.time.LocalDate;

public class ClientExerciseExecutionDto {
    private Long clientId;
    private Long exerciseExecutionId;

    private Double weight;

    private LocalDate date;

    private Boolean isPlan;

    private Boolean isCompliance;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getExerciseExecutionId() {
        return exerciseExecutionId;
    }

    public void setExerciseExecutionId(Long exerciseExecutionId) {
        this.exerciseExecutionId = exerciseExecutionId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getPlan() {
        return isPlan;
    }

    public void setPlan(Boolean plan) {
        isPlan = plan;
    }

    public Boolean getCompliance() {
        return isCompliance;
    }

    public void setCompliance(Boolean compliance) {
        isCompliance = compliance;
    }
}
