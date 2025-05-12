package com.bezkoder.spring.security.postgresql.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.security.postgresql.models.Ticket;
import com.bezkoder.spring.security.postgresql.payload.request.PlayRequest;
import com.bezkoder.spring.security.postgresql.payload.response.PlayResponse;
import com.bezkoder.spring.security.postgresql.payload.response.TicketStatsResponse;
import com.bezkoder.spring.security.postgresql.repository.TicketRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/play")
public class PlayController {

	@Autowired
	private TicketRepository ticketRepository;

	@PreAuthorize("hasRole('USER')")
	@PostMapping("/tip")
	public ResponseEntity<PlayResponse> playTip(@Valid @RequestBody PlayRequest play) {

		Optional<Ticket> ticketOpt = ticketRepository.findByNumber(play.getTicket());
		if(ticketOpt.isPresent()) {
			Ticket ticket = ticketOpt.get();
			if(ticket.getUtilise()) {
				return  ResponseEntity.ok(new PlayResponse(true,null, null) );
			}else if(ticket.getGagnant()) {
				ticket.setUsername(play.getUsername());
				ticket.setUtilise(true);
				ticketRepository.save(ticket);
				return  ResponseEntity.ok(new PlayResponse(false,true, ticket.getType()) );
			}else {
				return  ResponseEntity.ok(new PlayResponse(false,false, ticket.getType()) );
			}
		}else {
			return  ResponseEntity.ok(null);
		}
		
	}
	
	@PreAuthorize("hasRole('MODERATOR')")
	@GetMapping("/tipStats")
	public ResponseEntity<TicketStatsResponse> getWinTips() {

		TicketStatsResponse ticketOpt = ticketRepository.getTicketStats();
		return  ResponseEntity.ok(ticketOpt);
		
	}

}
