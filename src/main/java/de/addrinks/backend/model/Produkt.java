package de.addrinks.backend.model;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URL;
import java.util.Currency;
import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("produkt")
public class Produkt {

	public UUID getId() {
		return id;
	}
	@Id
	@Property("id")
	protected UUID id;
	
	private String Name;
	private UUID Kategorie;
	
	private int Bestand;
	private String Beschreibung;
	
	private int Punkte;
	private URI uri; 
	
	private BigDecimal Einkaufspreis;
	private String Waehrung;
	
	public Produkt(){
		id = UUID.randomUUID();
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public UUID getKategorie() {
		return Kategorie;
	}
	public void setKategorie(UUID kategorie) {
		Kategorie = kategorie;
	}
	public int getBestand() {
		return Bestand;
	}
	public void setBestand(int bestand) {
		Bestand = bestand;
	}
	public String getBeschreibung() {
		return Beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		Beschreibung = beschreibung;
	}
	public int getPunkte() {
		return Punkte;
	}
	public void setPunkte(int punkte) {
		Punkte = punkte;
	}
	public URI getUri() {
		return uri;
	}
	public void setUri(URI uri) {
		this.uri = uri;
	}
	public BigDecimal getEinkaufspreis() {
		return Einkaufspreis;
	}
	public void setEinkaufspreis(BigDecimal einkaufspreis) {
		Einkaufspreis = einkaufspreis;
	}
	public Currency getWaehrung() {
		return Currency.getInstance(Waehrung);
	}
	public void setWaehrung(Currency waehrung) {
		//Convert String to Currency. Morphia is not able to do.
		Waehrung = waehrung.toString();
	}
}
