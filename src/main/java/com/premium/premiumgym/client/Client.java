package com.premium.premiumgym.client;

import com.premium.premiumgym.client.staff.Measurement;
import com.premium.premiumgym.shift.Shift;
import com.premium.premiumgym.shift.Week;
import com.premium.premiumgym.zconfig.ConstantValues;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "ci")
    private String ci;

    @Column(name = "second_lastname")
    private String secondLastname;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ClientTrainingDay> trainingDays = new ArrayList<>();

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Measurement> measurements = new ArrayList<>();

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Change> changes = new ArrayList<>();

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ClientExerciseExecution> exerciseExecutions = new ArrayList<>();

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ClientPlan> plans = new ArrayList<>();

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Week week;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_id")
    private Shift shift;

    public List<ClientExerciseExecution> getExerciseExecutions() {
        return exerciseExecutions;
    }

    public void setExerciseExecutions(List<ClientExerciseExecution> exerciseExecutions) {
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

    public void setName(String cName) {
        this.name = cName;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String cLastname) {
        this.lastname = cLastname;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String cBirthdate) {
        this.birthdate = cBirthdate;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String cCi) {
        this.ci = cCi;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String cSecondLastname) {
        this.secondLastname = cSecondLastname;
    }

    public List<ClientTrainingDay> getTrainingDays() {
        return trainingDays;
    }

    public void setTrainingDays(List<ClientTrainingDay> trainingDays) {
        this.trainingDays = trainingDays;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public List<ClientPlan> getPlans() {
        return plans;
    }

    public void setPlans(List<ClientPlan> plans) {
        this.plans = plans;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public void copy(Client client) {
        this.name = client.getName();
        this.lastname = client.getLastname();
        this.secondLastname = client.getSecondLastname();
        this.birthdate = client.getBirthdate();
        this.ci = client.getCi();
        //this.trainingDays = client.trainingDays;
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (this.getClass() != obj.getClass())
            return false;

        return this.id != null && this.id.equals(((Client) obj).getId());
    }

    public List<Change> getChanges() {
        return changes;
    }

    public void setChanges(List<Change> changes) {
        this.changes = changes;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public void addMeasurement(Measurement measurement) {
        this.measurements.add(measurement);
    }

    public void removeMeasurement(Measurement measurement) {
        this.measurements.remove(measurement);
    }

    public void addChange(Change change)
    {
        this.changes.add(change);
    }

    public void removeChange(Change change)
    {
        this.changes.remove(change);
    }

    public void addExerciseExecution(ClientExerciseExecution clientExerciseExecution)
    {
        this.exerciseExecutions.add(clientExerciseExecution);
    }

    public void removeExerciseExecution(ClientExerciseExecution clientExerciseExecution)
    {
        this.exerciseExecutions.remove(clientExerciseExecution);
    }

    public void addPlan(ClientPlan clientPlan)
    {
        this.plans.add(clientPlan);
    }

    public void removePlan(ClientPlan clientPlan)
    {
        this.plans.remove(clientPlan);
    }

    /*public void addTrainingDay(ClientTrainingDay clientTrainingDay)
    {
        this.trainingDays.add(clientTrainingDay);
    }

    public void removeTrainingDay(ClientTrainingDay clientTrainingDay)
    {
        this.trainingDays.remove(clientTrainingDay);
    }*/

    //TODO generate clients remove just for test
    public static List<Client> generateClients()
    {
        List<Client> clients = new ArrayList<>();
        String[] names = {"Pedro", "Juan", "Mario", "Jesus", "Jorge", "Luis"};
        String[] lastNames = {"Rodriguez", "Hdez", "Gonzalez", "Lopez", "Ruiz", "Ramirez"};

        for (int i = 0; i < 20; i++)
        {
            int day = ConstantValues.RANDOM.nextInt(25);
            int month = ConstantValues.RANDOM.nextInt(12);
            int year = ConstantValues.RANDOM.nextInt(1950, 2005);
            Client client = new Client();
            client.setBirthdate(month + "/" + day + "/" + year);
            client.setCi("455567883930");
            client.setName(names[ConstantValues.RANDOM.nextInt(names.length)]);
            client.setLastname(lastNames[ConstantValues.RANDOM.nextInt(lastNames.length)]);
            client.setSecondLastname(lastNames[ConstantValues.RANDOM.nextInt(lastNames.length)]);


            clients.add(client);
        }

        return clients;
    }
}