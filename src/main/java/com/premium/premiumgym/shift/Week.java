package com.premium.premiumgym.shift;

import com.premium.premiumgym.client.Client;
import com.premium.premiumgym.zconfig.ConstantValues;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "days_of_week")
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean monday;
    public Boolean tuesday;
    public Boolean wednesday;

    public Boolean thursday;

    public Boolean friday;

    public Boolean saturday;

    public Boolean sunday;

    public Enum weekStartIn;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Boolean getMonday() {
        return monday;
    }

    public void setMonday(Boolean monday) {
        this.monday = monday;
    }

    public Boolean getTuesday() {
        return tuesday;
    }

    public void setTuesday(Boolean tuesday) {
        this.tuesday = tuesday;
    }

    public Boolean getWednesday() {
        return wednesday;
    }

    public void setWednesday(Boolean wednesday) {
        this.wednesday = wednesday;
    }

    public Boolean getThursday() {
        return thursday;
    }

    public void setThursday(Boolean thursday) {
        this.thursday = thursday;
    }

    public Boolean getFriday() {
        return friday;
    }

    public void setFriday(Boolean friday) {
        friday = friday;
    }

    public Boolean getSaturday() {
        return saturday;
    }

    public void setSaturday(Boolean saturday) {
        saturday = saturday;
    }

    public Boolean getSunday() {
        return sunday;
    }

    public void setSunday(Boolean sunday) {
        sunday = sunday;
    }

    public Enum getWeekStartIn() {
        return weekStartIn;
    }

    public void setWeekStartIn(Enum weekStartIn) {
        this.weekStartIn = weekStartIn;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void copy(Week weekDetails) {
        this.monday = weekDetails.getMonday();
        this.tuesday = weekDetails.getTuesday();
        this.wednesday = weekDetails.getWednesday();
        this.thursday = weekDetails.getThursday();
        this.friday = weekDetails.getFriday();
        this.saturday = weekDetails.getSaturday();
        this.sunday = weekDetails.getSunday();
    }

    //TDOO remove just for testing
    public static List<Week> generateWeeks()
    {
        List<Week> weeks = new ArrayList<>();

        for (int i = 0; i < 20; i++)
        {
            Week week = new Week();
            week.setMonday(ConstantValues.RANDOM.nextBoolean());
            week.setTuesday(ConstantValues.RANDOM.nextBoolean());
            week.setWednesday(ConstantValues.RANDOM.nextBoolean());
            week.setThursday(ConstantValues.RANDOM.nextBoolean());
            week.setFriday(ConstantValues.RANDOM.nextBoolean());
            week.setSaturday(ConstantValues.RANDOM.nextBoolean());
            week.setSunday(ConstantValues.RANDOM.nextBoolean());
            week.setWeekStartIn(ConstantValues.WEEK_DAYS.values()[ConstantValues.RANDOM.nextInt(6)]);
        }

        return weeks;
    }
}