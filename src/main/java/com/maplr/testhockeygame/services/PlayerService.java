package com.maplr.testhockeygame.services;

import com.maplr.testhockeygame.entities.Player;
import com.maplr.testhockeygame.entities.PlayerMapped;
import com.maplr.testhockeygame.utilities.PlayersWithSameNumberInTeamException;
import com.maplr.testhockeygame.utilities.TeamNotFoundException;

public interface PlayerService {

	PlayerMapped savePlayer(Player player, long year)
			throws TeamNotFoundException, PlayersWithSameNumberInTeamException;

	PlayerMapped updateCaptain(long number) throws TeamNotFoundException;
}
