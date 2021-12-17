package com.maplr.testhockeygame.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Position {

	defenseman("defenseman"), goaltender("goaltender"), forward("forward");

	@Getter
	private String value;

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
