package de.addrinks.backend.model;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Currency;
import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("produkt")
public class Produkt {

	@Id
	@Property("id")
	protected UUID id;
	
	private String Name;
	private Kategorie Kategorie;
	
	private int Bestand;
	private String Beschreibung;
	
	private int Punkte;
	private URL uri; 
	
	private BigDecimal Einkaufspreis;
	private Currency Waehrung;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Kategorie getKategorie() {
		return Kategorie;
	}
	public void setKategorie(Kategorie kategorie) {
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
	public URL getUri() {
		return uri;
	}
	public void setUri(URL uri) {
		this.uri = uri;
	}
	public BigDecimal getEinkaufspreis() {
		return Einkaufspreis;
	}
	public void setEinkaufspreis(BigDecimal einkaufspreis) {
		Einkaufspreis = einkaufspreis;
	}
	public Currency getWaehrung() {
		return Waehrung;
	}
	public void setWaehrung(Currency waehrung) {
		Waehrung = waehrung;
	}
}
