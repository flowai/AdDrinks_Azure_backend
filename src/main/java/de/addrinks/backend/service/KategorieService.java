package de.addrinks.backend.service;

import java.util.List;
import java.util.UUID;

import de.addrinks.backend.model.Kategorie;

public interface KategorieService {
	Kategorie getKategorie(UUID id);
	
	List<Kategorie> getKategorien();
	
	boolean kategorieExists(UUID id);
	
	void saveKategorie (Kategorie kategorie) throws Exception;

	void updateKategorie(UUID id, Kategorie kategorie) throws Exception;
	
	void deleteKategorieById(UUID id);

	void deleteAllKategories();
}
