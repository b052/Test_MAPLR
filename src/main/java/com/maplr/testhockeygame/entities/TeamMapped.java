package com.maplr.testhockeygame.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class TeamMapped {

	@Getter
	@Setter
	private long id;

	@Getter
	@Setter
	private String coach;

	@Getter
	@Setter
	private long year;

	@Getter
	@Setter
	private List<PlayerMapped> players;
}
