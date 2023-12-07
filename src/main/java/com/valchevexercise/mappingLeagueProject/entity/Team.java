package com.valchevexercise.mappingLeagueProject.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="team_name")
    private String name;
    @Column(name="team_size")
    private int teamSize;

    @Column(name="points")
    private int points;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="league_id")
    private League league;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name="team_id")
    private Coach coach;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "team")
    private List<Player>playerList;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="stadium_team",
            joinColumns =@JoinColumn (name="team_id"),
            inverseJoinColumns = @JoinColumn(name="stadium_id"))
    private List<Stadium> stadiumList;

    public Team(){

    }
    @Autowired
    public Team(String name, int teamSize, int points) {
        this.name = name;
        this.teamSize=teamSize;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addStadiumToTeam(Stadium stadium){
        if(stadiumList==null){
            stadiumList = new ArrayList<>();
        }
        stadiumList.add(stadium);
    }

    public void addMultipleStadiumsToTeam(List<Stadium>stadiums) {
        if (stadiumList == null) {
            stadiumList = new ArrayList<>();
        }
        for (var s : stadiums) {
            stadiumList.add(s);
        }
    }

        public void addPlayerToTeam(Player player ){
            if(playerList==null){
                playerList = new ArrayList<>();
            }
            playerList.add(player);
        }

        public void addMultiplePlayersToTeam(List<Player>players){
            if(playerList==null){
                playerList=new ArrayList<>();
            }
            for(var p:players){
                playerList.add(p);
            }
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamSize=" + teamSize +
                ", points=" + points +
                ", league=" + league +
                '}';
    }
}
