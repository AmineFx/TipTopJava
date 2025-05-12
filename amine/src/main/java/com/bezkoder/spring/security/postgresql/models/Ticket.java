package com.bezkoder.spring.security.postgresql.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Size(max = 20)
	private String username;

	
	@Size(max = 20)
	private String number;

	
	@Size(max = 20)
	private String type;

	
	private Boolean gagnant;

	
	private Boolean utilise;

	
	public Ticket(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 20) String number,
			@NotBlank @Size(max = 20) String type, @NotBlank Boolean gagnant, @NotBlank Boolean utilise) {
		super();
		this.username = username;
		this.number = number;
		this.type = type;
		this.gagnant = gagnant;
		this.utilise = utilise;
	}

	public Ticket() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getGagnant() {
		return gagnant;
	}

	public void setGagnant(Boolean gagnant) {
		this.gagnant = gagnant;
	}

	public Boolean getUtilise() {
		return utilise;
	}

	public void setUtilise(Boolean utilise) {
		this.utilise = utilise;
	}

}
