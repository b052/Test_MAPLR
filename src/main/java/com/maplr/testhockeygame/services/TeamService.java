package com.maplr.testhockeygame.services;

import com.maplr.testhockeygame.entities.Team;
import com.maplr.testhockeygame.utilities.TeamNotFoundException;

public interface TeamService {

	Team getTeamByYear(long year) throws TeamNotFoundException;

}
