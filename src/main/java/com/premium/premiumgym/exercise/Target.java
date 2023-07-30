package com.premium.premiumgym.exercise;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "target")
public class Target {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "target_id")
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnore
    @JoinTable(
            name = "target_exercise",
            joinColumns = @JoinColumn(name = "target_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise)
    {
        this.exercises.add(exercise);
    }

    public void copy(Target newTarget)
    {
        this.name = newTarget.getName();
    }

    //TODO remove just for test
    public static List<Target> generateTargets()
    {
        String [] targetsStr = {"Hipertrofia", "Fuerza Máxima", "Resistencia a la fuerza"};
        List<Target> targets = new ArrayList<>();

        for(String t : targetsStr)
        {
            Target target = new Target();
            target.setName(t);
            targets.add(target);
        }
        return targets;
    }



}