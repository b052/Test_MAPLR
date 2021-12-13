package com.maplr.testhockeygame.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maplr.testhockeygame.entities.Player;

public interface PlayerDao extends JpaRepository<Player, Long>{ 
}
