package com.premium.premiumgym.plan;

import com.premium.premiumgym.client.ClientPlan;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"PLAN\"")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"PLAN_ID\"", nullable = false)
    private Long id;

    private String name;

    private String description;

    private String version;

    private Enum gender;

    @OneToMany(
            mappedBy = "plan",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PlanMicro> micros = new ArrayList<>();

    @OneToMany(
            mappedBy = "plan",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ClientPlan> clients = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String mName) {
        this.name = mName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<PlanMicro> getMicros() {
        return micros;
    }

    public void setMicros(List<PlanMicro> micros) {
        this.micros = micros;
    }

    public List<ClientPlan> getClients() {
        return clients;
    }

    public void setClients(List<ClientPlan> clients) {
        this.clients = clients;
    }

    public void addMicro(PlanMicro micro)
    {
        this.micros.add(micro);
    }

    public void removeMicro(PlanMicro micro)
    {
        this.micros.remove(micro);
    }

    public void copy(Plan planDetails) {
        this.gender = planDetails.gender;
        this.description = planDetails.description;
        if(planDetails.getMicros() != null)
            this.micros = planDetails.getMicros();
        this.name = planDetails.getName();
        this.version = planDetails.getVersion();
    }

    public void addClient(ClientPlan client)
    {
        this.clients.add(client);
    }

    public void removeClient(ClientPlan client)
    {
        this.clients.remove(client);
    }
}