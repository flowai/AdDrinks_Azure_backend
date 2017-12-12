package de.addrinks.backend.model;

import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("punkteproview")
public class PunkteProView {

	@Id
	@Property("id")
	protected UUID id;
	
	private UUID videocontent;
	private int punkte;
	
	public PunkteProView(){
		id = UUID.randomUUID();
	}
	
	public UUID getVideocontent() {
		return videocontent;
	}
	public void setVideocontent(UUID videocontent) {
		this.videocontent = videocontent;
	}
	public int getPunkte() {
		return punkte;
	}
	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
	public UUID getId() {
		return id;
	}
	
	
}
