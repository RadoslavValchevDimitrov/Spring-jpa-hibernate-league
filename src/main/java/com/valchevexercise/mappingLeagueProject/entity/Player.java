package com.valchevexercise.mappingLeagueProject.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="age")
    private int age;

    @Column(name="position")
    private String position;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="player_id_a")
    private List<Assists>asistsList;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="player_id_g")
    private List<Goals>goalsList;

    public Player(){

    }
   @Autowired
    public Player(String firstName, String lastName, int age, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Assists> getAsistsList() {
        return asistsList;
    }

    public void setAsistsList(List<Assists> asistsList) {
        this.asistsList = asistsList;
    }

    public List<Goals> getGoalsList() {
        return goalsList;
    }

    public void setGoalsList(List<Goals> goalsList) {
        this.goalsList = goalsList;
    }
//add convenience method for adding assists for player

    public void addAssist(Assists asists){
        if(asistsList == null){
            asistsList = new ArrayList<>();
        }
        asistsList.add(asists);
    }

    // add convenience method for adding Goals to Player
    public void addGoals(Goals goals){
        if(goalsList==null){
            goalsList = new ArrayList<>();
        }
        goalsList.add(goals);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }
}
