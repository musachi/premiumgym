package com.premium.premiumgym.client.staff;

import com.premium.premiumgym.client.Client;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"MEASUREMENT\"")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"MEASUREMENT_ID\"", nullable = false)
    private Long id;

    private LocalDate date;

    private Float neck;

    private Float waist;

    private Float hip;

    private Float weight;

    private Float height;

    private Float subscapularis;

    private Float triceps;

    private Float bicipital;

    private Float suprailiac;

    private Float abdominal;

    private Float thigh;

    private Float leg;

    private Float imc;

    private Float fat;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "neck")
    public Float getNeck() {
        return neck;
    }

    public void setNeck(Float neck) {
        this.neck = neck;
    }

    @Column(name = "waist")
    public Float getWaist() {
        return waist;
    }

    public void setWaist(Float waist) {
        this.waist = waist;
    }

    @Column(name = "hip")
    public Float getHip() {
        return hip;
    }

    public void setHip(Float hip) {
        this.hip = hip;
    }

    @Column(name = "weight")
    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Column(name = "height")
    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    @Column(name = "subscapularis")
    public Float getSubscapularis() {
        return subscapularis;
    }

    public void setSubscapularis(Float subscapularis) {
        this.subscapularis = subscapularis;
    }

    @Column(name = "triceps")
    public Float getTriceps() {
        return triceps;
    }

    public void setTriceps(Float triceps) {
        this.triceps = triceps;
    }

    @Column(name = "bicipital")
    public Float getBicipital() {
        return bicipital;
    }

    public void setBicipital(Float bicipital) {
        this.bicipital = bicipital;
    }

    @Column(name = "suprailiac")
    public Float getSuprailiac() {
        return suprailiac;
    }

    public void setSuprailiac(Float suprailiac) {
        this.suprailiac = suprailiac;
    }

    @Column(name = "abdominal")
    public Float getAbdominal() {
        return abdominal;
    }

    public void setAbdominal(Float abdominal) {
        this.abdominal = abdominal;
    }

    @Column(name = "thigh")
    public Float getThigh() {
        return thigh;
    }

    public void setThigh(Float thigh) {
        this.thigh = thigh;
    }

    @Column(name = "leg")
    public Float getLeg() {
        return leg;
    }

    public void setLeg(Float leg) {
        this.leg = leg;
    }

    @Column(name = "imc")
    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    @Column(name = "fat")
    public Float getFat() {
        return fat;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void copy(Measurement newMeasurement) {
        this.abdominal = newMeasurement.getAbdominal();
        this.fat = newMeasurement.getFat();
        this.date = newMeasurement.getDate();
        this.hip = newMeasurement.getHip();
        this.bicipital = newMeasurement.getBicipital();
        this.height = newMeasurement.getHeight();
        this.imc = newMeasurement.getImc();
        this.leg = newMeasurement.getLeg();
        this.neck = newMeasurement.getNeck();
        this.suprailiac = newMeasurement.getSuprailiac();
        this.subscapularis = newMeasurement.getSubscapularis();
        this.thigh = newMeasurement.getThigh();
        this.triceps = newMeasurement.getTriceps();
        this.waist = newMeasurement.getWaist();
        this.weight = newMeasurement.getWeight();
        //this.client = newMeasurement.getClient();
    }
}