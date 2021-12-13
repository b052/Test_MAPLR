package com.maplr.testhockeygame.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maplr.testhockeygame.entities.Team;

public interface TeamDao extends JpaRepository<Team, Long> {

	Optional<Team> findTeamByYear(long year);

	@Query(value = "SELECT ID_TEAM FROM T_PLAYERS_USERS_ASSOCIATIONS WHERE ID_PLAYER =:idPlayer", nativeQuery = true)
	Long getIdTeamByIdPlayer(@Param(value = "idPlayer") long idPlayer);
}
