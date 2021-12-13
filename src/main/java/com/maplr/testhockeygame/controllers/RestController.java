package com.maplr.testhockeygame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.maplr.testhockeygame.entities.Player;
import com.maplr.testhockeygame.services.PlayerService;
import com.maplr.testhockeygame.services.TeamService;
import com.maplr.testhockeygame.utilities.PlayersWithSameNumberInTeamException;
import com.maplr.testhockeygame.utilities.TeamNotFoundException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	TeamService teamService;

	@Autowired
	PlayerService playerService;

	@GetMapping("/api/team/{year}")
	public Object getTeamByYear(@PathVariable(name = "year") long year) {

		try {
			return teamService.getTeamByYear(year);
		} catch (TeamNotFoundException e) {
			return (e.getMessage());
		}
	}

	@PostMapping("/api/team/{year}")
	public Object addPlayerInTeam(@PathVariable(name = "year") long year, @RequestBody Player player) {
		try {
			return playerService.savePlayer(player, year);
		} catch (TeamNotFoundException e) {
			return (e.getMessage());
		} catch (PlayersWithSameNumberInTeamException e) {
			return (e.getMessage());
		}
	}

	@PutMapping("/api/player/captain/{ID}")
	public Object updateCaptain(@PathVariable(name = "ID") long idJoueur) {
		try {
			return playerService.updateCaptain(idJoueur);
		} catch (TeamNotFoundException e) {
			return (e.getMessage());
		}
	}
}
