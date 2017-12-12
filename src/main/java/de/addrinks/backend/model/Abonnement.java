package de.addrinks.backend.model;

import java.sql.Timestamp;
import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity
public class Abonnement {

	@Id
	@Property("id")
	protected UUID id;
	
	private Timestamp start;
	private Timestamp ende;
	
	private int abokategorie;
	
	public Abonnement() {
		id = UUID.randomUUID();
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnde() {
		return ende;
	}

	public void setEnde(Timestamp ende) {
		this.ende = ende;
	}

	public int getAbokategorie() {
		return abokategorie;
	}

	public void setAbokategorie(int abokategorie) {
		this.abokategorie = abokategorie;
	}

	public UUID getId() {
		return id;
	}
	
}
