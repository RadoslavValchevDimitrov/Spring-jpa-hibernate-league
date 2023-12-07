package com.valchevexercise.mappingLeagueProject.DAO;

import com.valchevexercise.mappingLeagueProject.entity.*;

public interface AppDAO {
    void saveLeagueToDB(League league);

    void savePlayerToDB(Player player);

    void saveTeamToDB(Team team);

    League findLeagueById(int theId);

    Player findPlayerById(int theId);

    Team findTeamById(int theId);

    Stadium findStadiumById(int theId);

    void saveGoalsToDB(Goals goals);

    void saveAssistsToDB(Assists assists);
}
