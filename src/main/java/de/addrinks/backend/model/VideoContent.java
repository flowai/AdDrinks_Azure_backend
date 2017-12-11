package de.addrinks.backend.model;

import java.net.URI;
import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("videocontent")
public class VideoContent {
	
	@Id
	@Property("id")
	protected UUID id;

	private String titel;
	private String beschreibung;
	
	private URI videolink;
	private UUID kundenid;
	
	public VideoContent(){
		id = UUID.randomUUID();
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public URI getVideolink() {
		return videolink;
	}

	public void setVideolink(URI videolink) {
		this.videolink = videolink;
	}

	public UUID getKundenid() {
		return kundenid;
	}

	public void setKundenid(UUID kundenid) {
		this.kundenid = kundenid;
	}

	public UUID getId() {
		return id;
	}
	
	
}
