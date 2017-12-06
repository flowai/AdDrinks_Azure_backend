package de.addrinks.backend.model;

import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("kategorie")
public class Kategorie {
	
	@Id
	@Property("id")
	protected UUID id;
	
	private String KategorieName;
	private String Beschreibung;
	
	
	public String getKategorieName() {
		return KategorieName;
	}
	public void setKategorieName(String kategorieName) {
		KategorieName = kategorieName;
	}
	public String getBeschreibung() {
		return Beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		Beschreibung = beschreibung;
	}
}
