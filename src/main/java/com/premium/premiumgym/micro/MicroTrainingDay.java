package com.premium.premiumgym.micro;

import com.premium.premiumgym.trainingday.TrainingDay;
import jakarta.persistence.*;

@Entity
@Table(name = "micro_training_day")
public class MicroTrainingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "micro_training_day_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_day_id", nullable = false)
    private TrainingDay trainingDay;

    @ManyToOne
    @JoinColumn(name = "micro_id", nullable = false)
    private Micro micro;

    private Integer executionOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainingDay getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(TrainingDay trainingDay) {
        this.trainingDay = trainingDay;
    }

    public Micro getMicro() {
        return micro;
    }

    public void setMicro(Micro micro) {
        this.micro = micro;
    }

    public Integer getExecutionOrder() {
        return executionOrder;
    }

    public void setExecutionOrder(Integer executionOrder) {
        this.executionOrder = executionOrder;
    }
}