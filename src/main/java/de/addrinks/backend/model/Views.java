package de.addrinks.backend.model;

import java.sql.Timestamp;
import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("views")
public class Views {
	
	@Id
	@Property("id")
	protected UUID id;
	
	private UUID videoid;
	private UUID nutzerid;
	
	private float gpsx;
	private float gpsy;
	
	private Timestamp zeitstempel;
	
	public Views() {
		id = UUID.randomUUID();
	}

	public UUID getVideoid() {
		return videoid;
	}

	public void setVideoid(UUID videoid) {
		this.videoid = videoid;
	}

	public UUID getNutzerid() {
		return nutzerid;
	}

	public void setNutzerid(UUID nutzerid) {
		this.nutzerid = nutzerid;
	}

	public float getGpsx() {
		return gpsx;
	}

	public void setGpsx(float gpsx) {
		this.gpsx = gpsx;
	}

	public float getGpsy() {
		return gpsy;
	}

	public void setGpsy(float gpsy) {
		this.gpsy = gpsy;
	}

	public Timestamp getZeitstempel() {
		return zeitstempel;
	}

	public void setZeitstempel(Timestamp zeitstempel) {
		this.zeitstempel = zeitstempel;
	}

	public UUID getId() {
		return id;
	}
}
