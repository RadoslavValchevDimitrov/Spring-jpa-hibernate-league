package com.valchevexercise.mappingLeagueProject.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="stadium")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="stadium_name")
    private String stadiumName;
    @Column(name="city")
    private String city;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="stadium_team",
    joinColumns =@JoinColumn (name="stadium_id"),
    inverseJoinColumns = @JoinColumn(name="team_id"))
    private List<Team> teamList;


    public Stadium(){


    }
     @Autowired
    public Stadium(String stadiumName, String city) {
        this.stadiumName = stadiumName;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public void addTeamToStadium(Team team){
        if(teamList == null){
            teamList = new ArrayList<>();
        }
        teamList.add(team);
    }

    public void addMultipleTeamsToStadium(List<Team>teams){
        if(teamList==null){
            teamList = new ArrayList<>();
        }
        for(var t:teams){
            teamList.add(t);
        }
    }
}


