package com.premium.premiumgym.shift;

import com.premium.premiumgym.client.Client;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"SHIFT\"")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"shift_id\"", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_at")
    private LocalTime startAt;

    @Column(name = "end_at")
    private LocalTime endAt;

    @OneToMany(
            mappedBy = "shift",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Client> clients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String sName) {
        this.name = sName;
    }

    public LocalTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalTime startAt) {
        this.startAt = startAt;
    }

    public LocalTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalTime endAt) {
        this.endAt = endAt;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void copy(Shift shift){
        this.name = shift.getName();
        this.startAt = shift.getStartAt();
        this.endAt = shift.getEndAt();
    }

    //TODO remove only for test
    public static List<Shift> generateShifts()
    {
        Shift shift1 = new Shift();
        shift1.setName("1er Turno");
        shift1.setStartAt(LocalTime.of(7, 0, 0 ));
        shift1.setEndAt(shift1.getStartAt().plusHours(1).plusMinutes(30));

        Shift shift2 = new Shift();
        shift2.setName("2do Turno");
        shift2.setStartAt(LocalTime.of(8, 45, 0 ));
        shift2.setEndAt(shift1.getStartAt().plusHours(1).plusMinutes(30));

        Shift shift3 = new Shift();
        shift3.setName("3er Turno");
        shift3.setStartAt(LocalTime.of(10, 30, 0 ));
        shift3.setEndAt(shift1.getStartAt().plusHours(1).plusMinutes(30));

        List<Shift> shifts = new ArrayList<>();
        shifts.add(shift1);
        shifts.add(shift2);
        shifts.add(shift3);

        return shifts;
    }
}