package com.bezkoder.spring.security.postgresql.payload.response;

import java.util.List;

public class TicketStatsResponse {
	
	private Long numberWon;
    private Long numberLeftToWin;
    
	public Long getNumberWon() {
		return numberWon;
	}
	public void setNumberWon(Long numberWon) {
		this.numberWon = numberWon;
	}
	public Long getNumberLeftToWin() {
		return numberLeftToWin;
	}
	public void setNumberLeftToWin(Long numberLeftToWin) {
		this.numberLeftToWin = numberLeftToWin;
	}
	public TicketStatsResponse(Long numberWon, Long numberLeftToWin) {
		super();
		this.numberWon = numberWon;
		this.numberLeftToWin = numberLeftToWin;
	}
	public TicketStatsResponse() {
		super();
	}
	
}
