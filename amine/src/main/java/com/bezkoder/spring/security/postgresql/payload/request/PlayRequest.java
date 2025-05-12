package com.bezkoder.spring.security.postgresql.payload.request;

import jakarta.validation.constraints.NotBlank;

public class PlayRequest {
	@NotBlank
	private String username;

	@NotBlank
	private String ticket;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

}
