package com.premium.premiumgym.client;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientTrainingDayId implements Serializable {

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "training_day_id")
    private Long trainingDayId;

    ClientTrainingDayId(Long clientId, Long trainingDayId)
    {
        this.clientId = clientId;
        this.trainingDayId = trainingDayId;
    }

    ClientTrainingDayId() {}

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getTrainingDayId() {
        return trainingDayId;
    }

    public void setTrainingDayId(Long trainingDayId) {
        this.trainingDayId = trainingDayId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.clientId, this.trainingDayId);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        else if(obj == null || getClass() != obj.getClass())
            return false;

        ClientTrainingDayId clientTrainingDayId = (ClientTrainingDayId) obj;
        return  (this.clientId == clientTrainingDayId.getClientId())
                && this.trainingDayId == clientTrainingDayId.getTrainingDayId();
    }
}
