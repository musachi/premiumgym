package com.premium.premiumgym.trainingday;

import com.premium.premiumgym.client.ClientTrainingDay;
import com.premium.premiumgym.micro.MicroTrainingDay;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "training_day")
public class TrainingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_day_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(
            mappedBy = "trainingDay",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ClientTrainingDay> clients = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<TrainingDayEE> exerciseExecutions = new ArrayList<>();

    @OneToMany(
            mappedBy = "trainingDay",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MicroTrainingDay> micros = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String tName) {
        this.name = tName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String tDescription) {
        this.description = tDescription;
    }

    public List<TrainingDayEE> getTrainingDayExerciseExecutions() {
        return exerciseExecutions;
    }

    public void setTrainingDayExerciseExecutions(List<TrainingDayEE> trainingDayEES) {
        this.exerciseExecutions = trainingDayEES;
    }

    public List<TrainingDayEE> getExerciseExecutions() {
        return exerciseExecutions;
    }

    public void setExerciseExecutions(List<TrainingDayEE> exerciseExecutions) {
        this.exerciseExecutions = exerciseExecutions;
    }

    public List<ClientTrainingDay> getClients() {
        return clients;
    }

    public void setClients(List<ClientTrainingDay> clients) {
        this.clients = clients;
    }

    public void addExerciseExecution(@NotNull TrainingDayEE exerciseExecution)
    {
        this.exerciseExecutions.add(exerciseExecution);
    }

    public void removeExerciseExecution(@NotNull TrainingDayEE exerciseExecution)
    {
        this.exerciseExecutions.remove(exerciseExecution);
    }

    public List<MicroTrainingDay> getMicros() {
        return micros;
    }

    public void setMicros(List<MicroTrainingDay> micros) {
        this.micros = micros;
    }

    public void addMicro(MicroTrainingDay micro)
    {
        this.micros.add(micro);
    }

    public void removeMicro(MicroTrainingDay micro)
    {
        this.micros.remove(micro);
    }

    //TODO check all copy methods because several were updated later

    public void copy(TrainingDay newTrainingDay) {
        this.name = newTrainingDay.getName();
        this.description = newTrainingDay.getDescription();
    }


}