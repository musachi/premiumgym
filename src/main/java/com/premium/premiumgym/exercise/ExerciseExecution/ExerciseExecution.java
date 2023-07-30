package com.premium.premiumgym.exercise.ExerciseExecution;

import com.premium.premiumgym.client.ClientExerciseExecution;
import com.premium.premiumgym.exercise.Execution.Execution;
import com.premium.premiumgym.exercise.Exercise;
import com.premium.premiumgym.trainingday.TrainingDayEE;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table()
public class ExerciseExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_execution_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "execution_id", nullable = false)
    private Execution execution;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<TrainingDayEE> trainingDays = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<ClientExerciseExecution> clients = new ArrayList<>();

    public List<TrainingDayEE> getTrainingDays() {
        return trainingDays;
    }

    public void setTrainingDays(List<TrainingDayEE> trainingDays) {
        this.trainingDays = trainingDays;
    }

    public List<ClientExerciseExecution> getClients() {
        return clients;
    }

    public void setClients(List<ClientExerciseExecution> clients) {
        this.clients = clients;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Execution getExecution() {
        return execution;
    }

    public void setExecution(Execution execution) {
        this.execution = execution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void copy(@NotNull ExerciseExecution newEe) {
        this.exercise = newEe.getExercise();
        this.execution = newEe.getExecution();
    }

    public void addTrainingDay(TrainingDayEE trainingDay)
    {
        this.trainingDays.add(trainingDay);
    }

    public void removeTrainigDay(TrainingDayEE trainingDay) {
        this.trainingDays.remove(trainingDay);
    }

    public void addCient(ClientExerciseExecution client)
    {
        this.clients.add(client);
    }

    public void removeCient(ClientExerciseExecution client)
    {
        this.clients.remove(client);
    }
}