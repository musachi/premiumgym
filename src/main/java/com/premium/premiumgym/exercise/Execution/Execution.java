package com.premium.premiumgym.exercise.Execution;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecution;
import com.premium.premiumgym.zconfig.ConstantValues;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "execution")
public class Execution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "execution_id", nullable = false)
    private Long id;

    private Integer reps;

    private Double pause;

    private Float executionTime;

    private ConstantValues.TimeUnit timeUnit;

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ExerciseExecution> exerciseExecutions = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnore
    @JoinTable(
            name = "execution_serie",
            joinColumns = @JoinColumn(name = "execution_id"),
            inverseJoinColumns = @JoinColumn(name = "serie_id")
    )
    private List<Serie> series = new ArrayList<>();
    /*@ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnore
    @JoinTable(
            name = "exercise_execution",
            joinColumns = @JoinColumn(name = "execution_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")

    )
    private List<Exercise> exercises = new ArrayList<>();*/

    public List<ExerciseExecution> getExerciseExecutions() {
        return exerciseExecutions;
    }

    public void setExerciseExecutions(List<ExerciseExecution> exerciseExecutions) {
        this.exerciseExecutions = exerciseExecutions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Double getPause() {
        return pause;
    }

    public void setPause(Double pause) {
        this.pause = pause;
    }

    public Float getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Float executionTime) {
        this.executionTime = executionTime;
    }
    public ConstantValues.TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(ConstantValues.TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void addExerciseExecution(ExerciseExecution exerciseExecution)
    {
        this.exerciseExecutions.add(exerciseExecution);
    }

    public void copy(Execution newExecution) {
        this.name = newExecution.getName();
        this.reps = newExecution.getReps();
        this.executionTime = newExecution.getExecutionTime();
        this.pause = newExecution.getPause();
        //this.series = newExecution.getSeries();
        this.executionTime = newExecution.getExecutionTime();
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    public void setPlan(Boolean isPlan) {
        isPlan = isPlan;
    }

    /*public void addSerie(Serie series)
    {
        series.getExecutions().add(this);
        this.series.add(series);
    }*/

    //Test TODO remove this code, just for test
    public static List<Execution> generateExecution()
    {
        List<Execution> l = new ArrayList<>();

        short series = 3;

        for(int i = 0; i < series; i++)
        {
            String name = "Execution " + (i+1);

            Execution execution = new Execution();
            execution.setName(name);
            execution.setPause((double)ConstantValues.RANDOM.nextInt(ConstantValues.CHARACTERS.length()));
            execution.setReps(10);
            ConstantValues.TimeUnit timeUnit1 = i/2 == 0 ? ConstantValues.TimeUnit.MIN : ConstantValues.TimeUnit.SEC;
            execution.setTimeUnit(timeUnit1);

            l.add(execution);
        }

        return l;
    }
}