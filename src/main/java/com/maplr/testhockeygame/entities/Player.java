package com.maplr.testhockeygame.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.maplr.testhockeygame.enums.Position;

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
	private Position position;

	private Boolean isCaptain;

	public Boolean isIsCaptain() {
		return isCaptain;
	}

	public void setCaptain(Boolean isCaptain) {
		this.isCaptain = isCaptain;
	}

}
