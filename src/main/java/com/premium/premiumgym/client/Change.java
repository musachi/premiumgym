package com.premium.premiumgym.client;

import com.premium.premiumgym.shift.Shift;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "change")
public class Change {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "change_id", nullable = false)
    private Long id;

    private LocalDate oldDate;

    private LocalDate newDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shift_id", nullable = false)
    private Shift newShift;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOldDate() {
        return oldDate;
    }

    public void setOldDate(LocalDate oldDate) {
        this.oldDate = oldDate;
    }

    public LocalDate getNewDate() {
        return newDate;
    }

    public void setNewDate(LocalDate newDate) {
        this.newDate = newDate;
    }

    public Shift getNewShift() {
        return newShift;
    }

    public void setNewShift(Shift newShift) {
        this.newShift = newShift;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void copy(Change changeDatails)
    {
        this.oldDate = changeDatails.getOldDate();
        this.newDate = changeDatails.getNewDate();
        this.newShift = changeDatails.getNewShift();
        if(changeDatails.getClient() != null)
            this.client = changeDatails.getClient();
    }
}