package com.valchevexercise.mappingLeagueProject;

import com.valchevexercise.mappingLeagueProject.DAO.AppDAO;
import com.valchevexercise.mappingLeagueProject.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MappingLeagueProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingLeagueProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner->{
         // saveLeagueToDB(appDAO);

		  //addGoalsAndAssistsForPlayer(appDAO);

			//addPlayerWithGoalsAndAssists(appDAO);

			//saveGoalsToDB(appDAO);

			//saveTeamAndPlayers(appDAO);
			//saveTeamAndListOfPlayers(appDAO);
			saveGoalsAndAssistToExistingPlayer(appDAO);
		};
	}

	private void saveGoalsAndAssistToExistingPlayer(AppDAO appDAO) {
		int theId = 2;
		Player player = appDAO.findPlayerById(theId);
		Goals goals = new Goals("Head","Penalty Area",37.3);
		Assists assists= new Assists("Long Pass");
		player.addAssist(assists);
		player.addGoals(goals);
		appDAO.saveGoalsToDB(goals);


	}

	private void saveTeamAndListOfPlayers(AppDAO appDAO) {

		Team Milan = new Team(" AC Milan",21,28);
		Player teo = new Player("Teo","Hernandez",33,"Defender");
		Player leo = new Player("Rafael","Leao",23,"Artificial 9");

		List<Player>playerList = new ArrayList<>();
		playerList.add(teo);
		playerList.add(leo);
		for(var p:playerList){
			p.setTeam(Milan);
		}
		Milan.addMultiplePlayersToTeam(playerList);
		appDAO.saveTeamToDB(Milan);

	}

	private void saveTeamAndPlayers(AppDAO appDAO) {

		Team Lazio = new Team(" Lazio",22,35);
		Player ciro = new Player("Ciro","Immobile",33,"Forward");
		Player zacani = new Player("Mateo","Zacani",33,"Wing");
		Player pedro = new Player("Pedro","Rodriguez",33,"Wing");
		Player luis = new Player("Luis","Alberto",24,"Midfielder");
		Player provedel = new Player("Ivan","Provedel",28,"Goalkeeper");

		ciro.setTeam(Lazio);Lazio.addPlayerToTeam(ciro);
		zacani.setTeam(Lazio);Lazio.addPlayerToTeam(zacani);
		pedro.setTeam(Lazio);Lazio.addPlayerToTeam(pedro);
		luis.setTeam(Lazio);Lazio.addPlayerToTeam(luis);
		provedel.setTeam(Lazio);Lazio.addPlayerToTeam(provedel);
		appDAO.saveTeamToDB(Lazio);
	}

	private void saveGoalsToDB(AppDAO appDAO) {

		Goals goals = new Goals("With head","In the middle of penalty area",33.2);
		appDAO.saveGoalsToDB(goals);
	}

	private void addPlayerWithGoalsAndAssists(AppDAO appDAO) {
		Player ciro = new Player("Ciro","Immobile",33,"Forward");
		ciro.addGoals(new Goals("With head","In the middle of penalty area",33.2));
		ciro.addAssist(new Assists("With trick pass behind the back of the defender"));
		appDAO.savePlayerToDB(ciro);
	}

	private void addGoalsAndAssistsForPlayer(AppDAO appDAO) {
		Player player  = new Player("Ciro","Immobile",33,"Forward");
		player.addAssist(new Assists("With left pass"));
		player.addGoals(new Goals("With shot","At the edge",92.5));

	}

	private void saveLeagueToDB(AppDAO appDAO) {
		League league = new League();
	}

}
