package de.addrinks.backend.model;

import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;


@Entity("user")
public class User {
	
	@Id
	@Property("id")
	protected UUID id;
	
	private String Vorname;
	private String Nachname;
	
	private int Geburtsjahr;
	private int Geburtsmonat;
	private int Geburtstag;
	
	private String Straße;
	private String Hausnummer;
	
	private String Ort;
	private int PLZ;
	
	public User() {
		id = UUID.randomUUID();
	}
	
	public String getVorname() {
		return Vorname;
	}
	public void setVorname(String vorname) {
		Vorname = vorname;
	}
	public String getNachname() {
		return Nachname;
	}
	public void setNachname(String nachname) {
		Nachname = nachname;
	}
	public int getGeburtsjahr() {
		return Geburtsjahr;
	}
	public void setGeburtsjahr(int geburtsjahr) {
		Geburtsjahr = geburtsjahr;
	}
	public int getGeburtsmonat() {
		return Geburtsmonat;
	}
	public void setGeburtsmonat(int geburtsmonat) {
		Geburtsmonat = geburtsmonat;
	}
	public int getGeburtstag() {
		return Geburtstag;
	}
	public void setGeburtstag(int geburtstag) {
		Geburtstag = geburtstag;
	}
	public String getStraße() {
		return Straße;
	}
	public void setStraße(String straße) {
		Straße = straße;
	}
	public String getHausnummer() {
		return Hausnummer;
	}
	public void setHausnummer(String hausnummer) {
		Hausnummer = hausnummer;
	}
	public String getOrt() {
		return Ort;
	}
	public void setOrt(String ort) {
		Ort = ort;
	}
	public int getPLZ() {
		return PLZ;
	}
	public void setPLZ(int pLZ) {
		PLZ = pLZ;
	}
	public UUID getId() {
		return id;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Geburtsjahr != other.Geburtsjahr)
			return false;
		if (Geburtsmonat != other.Geburtsmonat)
			return false;
		if (Geburtstag != other.Geburtstag)
			return false;
		if (Hausnummer == null) {
			if (other.Hausnummer != null)
				return false;
		} else if (!Hausnummer.equals(other.Hausnummer))
			return false;
		if (Nachname == null) {
			if (other.Nachname != null)
				return false;
		} else if (!Nachname.equals(other.Nachname))
			return false;
		if (Ort == null) {
			if (other.Ort != null)
				return false;
		} else if (!Ort.equals(other.Ort))
			return false;
		if (PLZ != other.PLZ)
			return false;
		if (Straße == null) {
			if (other.Straße != null)
				return false;
		} else if (!Straße.equals(other.Straße))
			return false;
		if (Vorname == null) {
			if (other.Vorname != null)
				return false;
		} else if (!Vorname.equals(other.Vorname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Vorname=" + Vorname + ", Nachname=" + Nachname + ", Geburtsjahr=" + Geburtsjahr
				+ ", Geburtsmonat=" + Geburtsmonat + ", Geburtstag=" + Geburtstag + ", Straße=" + Straße
				+ ", Hausnummer=" + Hausnummer + ", Ort=" + Ort + ", PLZ=" + PLZ + "]";
	}
	
}
