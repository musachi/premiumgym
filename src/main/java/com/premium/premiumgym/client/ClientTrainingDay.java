package com.premium.premiumgym.client;

import com.premium.premiumgym.trainingday.TrainingDay;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "client_training_day")
public class ClientTrainingDay {

    @EmbeddedId
    private ClientTrainingDayId id;

    private LocalDate date;

    private Boolean assistance = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("trainingDayId")
    private TrainingDay trainingDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clientId")
    private Client client;

    ClientTrainingDay(Client client, TrainingDay trainingDay){
        this.client = client;
        this.trainingDay = trainingDay;
        this.id = new ClientTrainingDayId(client.getId(), trainingDay.getId());
    }

    ClientTrainingDay()
    {}

    public ClientTrainingDay(ClientTrainingDayId id) {
        this.id = id;
    }

    public ClientTrainingDayId getId() {
        return id;
    }

    public void setId(ClientTrainingDayId id) {
        this.id = id;
    }

    @Column(name = "date", nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "assistance", nullable = false)
    public Boolean getAssistance() {
        return this.assistance;
    }

    public void setAssistance(Boolean assistance) {
        this.assistance = assistance;
    }

    public TrainingDay getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(TrainingDay trainingDay) {
        this.trainingDay = trainingDay;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        else if (this.getClass() != obj.getClass())
            return false;

        return this.id != null && this.id.equals(((Client)obj).getId());
    }
}