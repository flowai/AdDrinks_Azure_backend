package de.addrinks.backend.model;

import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("kunde")
public class Kunde {

	@Id
	@Property("id")
	protected UUID id;
	
	private UUID Nutzer;
	private UUID Abo;
	
	private String Bezahlung;
	
	public Kunde(){
		id = UUID.randomUUID();
	}

	public UUID getNutzer() {
		return Nutzer;
	}

	public void setNutzer(UUID nutzer) {
		Nutzer = nutzer;
	}

	public UUID getAbo() {
		return Abo;
	}

	public void setAbo(UUID abo) {
		Abo = abo;
	}

	public String getBezahlung() {
		return Bezahlung;
	}

	public void setBezahlung(String bezahlung) {
		Bezahlung = bezahlung;
	}

	public UUID getId() {
		return id;
	}
	
	
}
