package com.maplr.testhockeygame.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplr.testhockeygame.daos.TeamDao;
import com.maplr.testhockeygame.entities.Team;
import com.maplr.testhockeygame.utilities.TeamNotFoundException;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamDao teamDao;

	@Override
	public Team getTeamByYear(long year) throws TeamNotFoundException {
		Optional<Team> team = teamDao.findTeamByYear(year);
		if (team.isPresent())
			return team.get();
		else
			throw new TeamNotFoundException("L'équipe n'existe pas dans la base de données !");
	}

}
