package com.maplr.testhockeygame.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TEAM")
public class Team {

	@Id
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
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_Players_Users_Associations", joinColumns = @JoinColumn(name = "idTeam"), inverseJoinColumns = @JoinColumn(name = "idPlayer"))
	private List<Player> players;

}
