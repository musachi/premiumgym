package com.premium.premiumgym.micro;

/**
 * A DTO for the {@link MicroTrainingDay} entity
 */
public class MicroTrainingDayDto {
    private Long microId;

    private Long trainingDayId;

    private int executionOrder;

    public Long getMicroId() {
        return microId;
    }

    public void setMicroId(Long microId) {
        this.microId = microId;
    }

    public Long getTrainingDayId() {
        return trainingDayId;
    }

    public void setTrainingDayId(Long trainingDayId) {
        this.trainingDayId = trainingDayId;
    }

    public int getExecutionOrder() {
        return executionOrder;
    }

    public void setExecutionOrder(int executionOrder) {
        this.executionOrder = executionOrder;
    }
}
