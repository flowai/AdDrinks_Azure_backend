package de.addrinks.backend.model;

import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("bestellung")
public class Bestellung {

	@Id
	@Property("id")
	protected UUID id;
	
	private UUID NutzerId;
	//TODO Produkt IDS! (Array)
	private UUID ProduktId;
	
	private int Menge;
	private String Status;
	
	public Bestellung() {
		id = UUID.randomUUID();
	}

	public UUID getNutzerId() {
		return NutzerId;
	}

	public void setNutzerId(UUID nutzerId) {
		NutzerId = nutzerId;
	}

	public UUID getProduktId() {
		return ProduktId;
	}

	public void setProduktId(UUID produktId) {
		ProduktId = produktId;
	}

	public int getMenge() {
		return Menge;
	}

	public void setMenge(int menge) {
		Menge = menge;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public UUID getId() {
		return id;
	}
}
