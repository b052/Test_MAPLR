package com.maplr.testhockeygame.utilities;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.maplr.testhockeygame.entities.Player;
import com.maplr.testhockeygame.entities.PlayerMapped;
import com.maplr.testhockeygame.entities.Team;
import com.maplr.testhockeygame.entities.TeamMapped;

@Mapper
public interface PlayerMapper {

	PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

	PlayerMapped PlayerToPlayerMapped(Player player);

	List<PlayerMapped> playersToPlayersMapped(List<Player> players);
	
	TeamMapped teamToTeamMapped(Team team);

}
