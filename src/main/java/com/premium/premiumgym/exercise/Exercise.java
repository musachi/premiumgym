package com.premium.premiumgym.exercise;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.premium.premiumgym.classification.Classification;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecution;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "\"EXERCISE\"")
@NamedQueries({
        @NamedQuery(name = "Exercise.findByNameLikeIgnoreCase", query = "select e from Exercise e where upper(e.name) like upper(:name)"),
        @NamedQuery(name = "Exercise.deleteByNameLikeIgnoreCase", query = "delete from Exercise e where upper(e.name) like upper(:name)")
})
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"EXERCISE_ID\"", nullable = false)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "name_contraction", unique = true)
    private String nameContraction;

    @Column(name = "description")
    private String description = "";

    @ManyToMany(mappedBy = "exercises",
            cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnore
    private List<Target> targets = new ArrayList<>();

    @ManyToMany(mappedBy = "exercises",
            cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnore
    private List<Classification> classifications = new ArrayList<>();

    /*@ManyToMany(mappedBy = "exercises",
            cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnore
    private List<Execution> executions = new ArrayList<>();*/

    @ManyToMany(cascade = CascadeType.ALL)
    private List<ExerciseExecution> exerciseExecutions = new ArrayList<>();

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

    public String getName() {
        return name;
    }

    public void setName(String eName) {
        this.name = eName;
    }

    public String getNameContraction() {
        return nameContraction;
    }

    public void setNameContraction(String eNameContraction) {
        this.nameContraction = eNameContraction;
    }

    public String getDescription() {
        return description;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public void setDescription(String eDescription) {
        this.description = eDescription;
    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }

    public void addTarget(Target target) {
        this.targets.add(target);
    }

    public void addExerciseExecution(ExerciseExecution exerciseExecution)
    {
        this.exerciseExecutions.add(exerciseExecution);
    }

    public void addClassification(Classification classification)
    {
        this.classifications.add(classification);
    }

    public void copy(Exercise exerciseDetails) {
        this.name = exerciseDetails.getName();
        this.description = exerciseDetails.getDescription();
        this.nameContraction = exerciseDetails.getNameContraction();
        if(exerciseDetails.getTargets() != null)
        {
            this.targets = exerciseDetails.getTargets();
        }
        if(exerciseDetails.getExerciseExecutions() != null)
        {
            this.exerciseExecutions = exerciseDetails.getExerciseExecutions();
        }
        if(exerciseDetails.getClassifications() != null && exerciseDetails.getClassifications().size() > 0)
        {
            this.classifications = exerciseDetails.getClassifications();
        }
    }

    //TODO only for test
    public static List<Exercise> generateExercises()
    {
        HashMap<String, String> exerciseStr = new HashMap<String, String>(){
            {
                put("Cuclillas", "Ccllsn");
                put("Cuclillas Cerradas", "Cclls Crrds");
                put("Split Sqt c/barra", "Split Sqt");
                put("Asalto lateral", "Aslto Ltrl");
                put("Avanzada", "Avanzada");
                put("Cuclillas Frontal", "Split SqtCclls Frntls");
                put("Peso Muerto", "Peso M");
                put("Fuerza Inclinda", "Frz Incld");
            }
        };

        List<Exercise> exercises = new ArrayList<>();
        exerciseStr.forEach((name, nameCtr) -> {
            Exercise exercise = new Exercise();
            exercise.setName(name);
            exercise.setNameContraction(nameCtr);

            exercises.add(exercise);
        });

        return exercises;
    }
}