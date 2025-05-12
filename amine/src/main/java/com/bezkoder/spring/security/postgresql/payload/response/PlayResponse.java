package com.bezkoder.spring.security.postgresql.payload.response;

import java.util.List;

public class PlayResponse {
	
	private Boolean winner;
	
	private Boolean used;
	
	private String type;

	
	public PlayResponse(Boolean used, Boolean winner, String type) {
		super();
		this.winner = winner;
		this.used = used;
		this.type = type;
	}

	public Boolean getWinner() {
		return winner;
	}

	public void setWinner(Boolean winner) {
		this.winner = winner;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}





}
