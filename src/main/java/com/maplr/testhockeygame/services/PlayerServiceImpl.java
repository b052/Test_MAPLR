package com.maplr.testhockeygame.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplr.testhockeygame.daos.PlayerDao;
import com.maplr.testhockeygame.daos.TeamDao;
import com.maplr.testhockeygame.entities.Player;
import com.maplr.testhockeygame.entities.PlayerMapped;
import com.maplr.testhockeygame.entities.Team;
import com.maplr.testhockeygame.utilities.PlayerMapper;
import com.maplr.testhockeygame.utilities.PlayersWithSameNumberInTeamException;
import com.maplr.testhockeygame.utilities.TeamNotFoundException;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	TeamService teamService;

	@Autowired
	TeamDao teamDao;

	@Autowired
	PlayerDao playerDao;

	@Override
	public PlayerMapped savePlayer(Player player, long year)
			throws TeamNotFoundException, PlayersWithSameNumberInTeamException {

		Optional<Team> team = Optional.of(teamService.getTeamByYear(year));
		boolean ajouter = true;
		if (team.isPresent()) {
			for (Player playerInTeam : team.get().getPlayers()) {
				if (playerInTeam.getNumber() == player.getNumber()) {
					ajouter = false;
					break;
				}
			}
			if (ajouter) {
				if(player.isIsCaptain() == true) {
					for (Player ply : team.get().getPlayers()) {
						ply.setCaptain(false);
					}
				}
				team.get().getPlayers().add(player);
				teamDao.save(team.get());
				return PlayerMapper.INSTANCE.PlayerToPlayerMapped(player);
			} else
				throw new PlayersWithSameNumberInTeamException(
						"Impossible d'ajouter ce joueur dans l'équipe car il existe dèjà un joueur avec le même numero dans l'équipe !");
		} else {
			throw new TeamNotFoundException("L'équipe n'existe pas dans la base de données !");
		}
	}

	@Override
	public PlayerMapped updateCaptain(long number) throws TeamNotFoundException {

		Long idTeam = teamDao.getIdTeamByIdPlayer(number);
		Optional<Team> team = null;
		Player playerToReturn = new Player();
		if (idTeam != null) {
			team = teamDao.findById(idTeam);
			for (Player player : team.get().getPlayers()) {
				if (player.getNumber() == number) {
					player.setCaptain(true);
					playerToReturn = player;
				} else {
					player.setCaptain(false);
				}
			}
			teamDao.save(team.get());
			return PlayerMapper.INSTANCE.PlayerToPlayerMapped(playerToReturn);
		} else
			throw new TeamNotFoundException("L'équipe n'existe pas dans la base de données !");
	}

}
