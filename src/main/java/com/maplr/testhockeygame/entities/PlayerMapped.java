package com.maplr.testhockeygame.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerMapped {

	private long number;

	private String name;

	private String lastname;

	private String position;

	@JsonInclude(value = Include.NON_NULL)
	private Boolean isCaptain;

	public Boolean isIsCaptain() {
		return isCaptain;
	}

	public void setIsCaptain(Boolean isCaptain) {
		this.isCaptain = isCaptain ? isCaptain : null;
	}
}
