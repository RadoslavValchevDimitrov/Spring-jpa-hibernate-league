package com.valchevexercise.mappingLeagueProject.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="league")
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="country")
    private String country;
    @Column(name="league_name")
    private String name;

    @Column(name="size")
    private  final int LEAGUE_SIZE = 20;


    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "league")
    private List<Team>teamList;



    public League(){

    }

    public League(String country, String name) {
        this.country = country;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLEAGUE_SIZE() {
        return LEAGUE_SIZE;
    }

    // add convenience method for adding Teams to the league

    public void addTeamToLeague(Team team){
        if(teamList ==  null){
            teamList = new ArrayList<>();
        }
        teamList.add(team);
    }
    public void addListOfTeamsToLeague(List<Team>teams){
        if(teamList== null){
            teamList = new ArrayList<>();
        }
        teamList.addAll(teams);
    }

    @Override
    public String toString() {
        return "League{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", LEAGUE_SIZE=" + LEAGUE_SIZE +
                '}';
    }
}
