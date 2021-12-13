package com.maplr.testhockeygame.services;

import com.maplr.testhockeygame.entities.Player;
import com.maplr.testhockeygame.utilities.PlayersWithSameNumberInTeamException;
import com.maplr.testhockeygame.utilities.TeamNotFoundException;

public interface PlayerService {

	Player savePlayer(Player player, long year) throws TeamNotFoundException, PlayersWithSameNumberInTeamException;

	Player updateCaptain(long number) throws TeamNotFoundException;
}
