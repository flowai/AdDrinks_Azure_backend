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
	
	private String Kategoriename;
	private String Beschreibung;
	
	public Kategorie(){
		id = UUID.randomUUID();
	}
	
	public UUID getId() {
		return id;
	}
	public String getKategoriename() {
		return Kategoriename;
	}
	public void setKategoriename(String kategorieName) {
		Kategoriename = kategorieName;
	}
	public String getBeschreibung() {
		return Beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		Beschreibung = beschreibung;
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
		Kategorie other = (Kategorie) obj;
		if (Beschreibung == null) {
			if (other.Beschreibung != null)
				return false;
		} else if (!Beschreibung.equals(other.Beschreibung))
			return false;
		if (Kategoriename == null) {
			if (other.Kategoriename != null)
				return false;
		} else if (!Kategoriename.equals(other.Kategoriename))
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
		return "Kategorie [id=" + id + ", Kategoriename=" + Kategoriename + ", Beschreibung=" + Beschreibung + "]";
	}
	
}
