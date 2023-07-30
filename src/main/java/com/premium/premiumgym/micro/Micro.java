package com.premium.premiumgym.micro;

import com.premium.premiumgym.plan.PlanMicro;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"MICRO\"")
public class Micro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"MICRO_ID\"", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "version")
    private String version;

    @Column(name = "gender")
    private Enum gender;

    @OneToMany(
            mappedBy = "micro",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MicroTrainingDay> trainigDays = new ArrayList<>();

    @OneToMany(
            mappedBy = "micro",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PlanMicro> plans = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String mDescription) {
        this.description = mDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Enum getGender() {
        return gender;
    }

    public void setGender(Enum gender) {
        this.gender = gender;
    }

    public List<MicroTrainingDay> getTrainigDays() {
        return trainigDays;
    }

    public void setTrainigDays(List<MicroTrainingDay> trainigDays) {
        this.trainigDays = trainigDays;
    }

    public List<PlanMicro> getPlans() {
        return plans;
    }

    public void setPlans(List<PlanMicro> plans) {
        this.plans = plans;
    }

    public void addTrainingDay(MicroTrainingDay trainingDay)
    {
        this.trainigDays.add(trainingDay);
    }

    public void removeTrainingDay(MicroTrainingDay trainingDay)
    {
        this.trainigDays.remove(trainingDay);
    }

    public void addPlan(PlanMicro plan)
    {
        this.plans.add(plan);
    }

    public void removePlan(PlanMicro plan)
    {
        this.plans.remove(plan);
    }

    public void copy(Micro microDetails) {
        this.gender = microDetails.getGender();
        this.description = microDetails.getDescription();
        this.version = microDetails.getVersion();
        this.name = microDetails.getName();
        if(microDetails.trainigDays != null)
            this.trainigDays = microDetails.getTrainigDays();
    }
}