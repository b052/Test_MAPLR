package com.maplr.testhockeygame.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLAYER")
public class Player {

	@Id
	@Getter
	@Setter
	private long number;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String lastname;

	@Getter
	@Setter
	private String position;

	private boolean isCaptain;

	public boolean isIsCaptain() {
		return isCaptain;
	}

	public void setCaptain(boolean isCaptain) {
		this.isCaptain = isCaptain;
	}

}
