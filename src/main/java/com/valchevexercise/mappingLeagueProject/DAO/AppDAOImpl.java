package com.valchevexercise.mappingLeagueProject.DAO;

import com.valchevexercise.mappingLeagueProject.entity.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void saveLeagueToDB(League league) {
        entityManager.persist(league);
    }

    @Override
    @Transactional
    public void savePlayerToDB(Player player) {
        entityManager.persist(player);
    }

    @Override
    @Transactional
    public void saveTeamToDB(Team team) {
        entityManager.persist(team);
    }

    @Override
    public League findLeagueById(int theId) {
        return entityManager.find(League.class,theId);
    }

    @Override
    public Player findPlayerById(int theId) {
        return entityManager.find(Player.class,theId);
    }

    @Override
    public Team findTeamById(int theId) {
        return entityManager.find(Team.class,theId);
    }

    @Override
    public Stadium findStadiumById(int theId) {
        return entityManager.find(Stadium.class,theId);
    }

    @Override
    @Transactional
    public void saveGoalsToDB(Goals goals) {
        entityManager.persist(goals);
    }

    @Override
    @Transactional
    public void saveAssistsToDB(Assists assists) {
        entityManager.persist(assists);
    }


}
