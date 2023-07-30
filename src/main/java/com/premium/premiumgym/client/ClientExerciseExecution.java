package com.premium.premiumgym.client;

import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecution;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "client_exercise_execution")
public class ClientExerciseExecution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_exercise_execution", nullable = false)
    private Long id;

    private double weight;

    private Boolean isPlan = false;

    private Boolean isCompliance = true;

    public LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //TODO REMOVE in compliance the real weight
    //TODO check if is neccesary
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "exercise_execution_id", nullable = false)
    private ExerciseExecution exerciseExecution;

    @ManyToOne
    @JoinColumn(name = "\"client_id\"", nullable = false)
    private Client client;

    public ExerciseExecution getExerciseExecution() {
        return exerciseExecution;
    }

    public void setExerciseExecution(ExerciseExecution exerciseExecution) {
        this.exerciseExecution = exerciseExecution;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public void attrFromClientExerciseExecutionDto(ClientExerciseExecutionDto clientExerciseExecutionDto)
    {
        this.weight = clientExerciseExecutionDto.getWeight();
        this.date = clientExerciseExecutionDto.getDate();
        this.isCompliance = clientExerciseExecutionDto.getCompliance();
        this.isPlan = clientExerciseExecutionDto.getPlan();
    }
}