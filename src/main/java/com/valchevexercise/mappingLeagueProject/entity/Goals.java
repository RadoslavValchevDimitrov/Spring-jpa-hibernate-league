package com.valchevexercise.mappingLeagueProject.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="goals")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "method")
    private String method;
    @Column(name="location")
    private String location;
    @Column(name="shot_speed")
    private double shotSpeed;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "goals")
    Assists assists;


    public Goals(){

    }

    @Autowired
    public Goals(String method, String location, double shotSpeed) {
        this.method = method;
        this.location = location;
        this.shotSpeed = shotSpeed;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getShotSpeed() {
        return shotSpeed;
    }

    public void setShotSpeed(double shotSpeed) {
        this.shotSpeed = shotSpeed;
    }

    @Override
    public String toString() {
        return "Goals{" +
                "method='" + method + '\'' +
                ", location='" + location + '\'' +
                ", shotSpeed=" + shotSpeed +
                '}';
    }
}
