package com.maplr.testhockeygame.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class JsonResponseBody {

	@Getter @Setter
	private int server;
	
	@Getter @Setter
	private Object response;
}


/*
 * http response become java object of ResponseEntity<JsonResponseBody>
 * 
 * header -> jwt
 * 
 * body -> a html page or jsonMessage(JsonResponseBody(server, response))
 */