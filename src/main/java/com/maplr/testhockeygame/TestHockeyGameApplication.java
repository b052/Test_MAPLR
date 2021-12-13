package com.maplr.testhockeygame;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maplr.testhockeygame.daos.PlayerDao;
import com.maplr.testhockeygame.daos.TeamDao;
import com.maplr.testhockeygame.entities.Player;
import com.maplr.testhockeygame.entities.Team;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class TestHockeyGameApplication implements CommandLineRunner {

	@Autowired
	TeamDao teamDao;

	@Autowired
	PlayerDao playerDao;

	public static void main(String[] args) {
		SpringApplication.run(TestHockeyGameApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("Remplissons notre base de données H2 !");

		Player carey = new Player(31, "Carey", "Price", "goaltender", false);
		Player nick = new Player(14, "Nick", "Suzuki", "forward", false);
		Player jesperi = new Player(15, "Jesperi", "Kotkaniemi", "forward", false);
		Player jake = new Player(71, "Jake", "Evans", "forward", false);
		Player alexander = new Player(27, "Alexander", "Romanov", "defenseman", false);
		Player shea = new Player(6, "Shea", "Weber", "forward", true);

		List<Player> playerTeam2020 = Arrays.asList(carey, nick, jesperi);

		List<Player> playerTeam2019 = Arrays.asList(jake, alexander, shea);

		Team teams2019 = new Team(1, "Dominique Ducharme", 2019, playerTeam2019);
		Team teams2020 = new Team(2, "Abdou Lahat", 2020, playerTeam2020);
		teamDao.save(teams2020);
		teamDao.save(teams2019);

		log.info("Nous avons fini de remplir notre base de données H2 !");

	}

}
