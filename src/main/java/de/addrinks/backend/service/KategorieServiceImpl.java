package de.addrinks.backend.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.addrinks.backend.azure.MongoDBController;
import de.addrinks.backend.model.Kategorie;

@Service
public class KategorieServiceImpl implements KategorieService {
	public static final Logger logger = LoggerFactory.getLogger(KategorieServiceImpl.class);
	
	@Autowired
	MongoDBController mongoDBController;
	
	@Override
	public Kategorie getKategorie(UUID id) {
		logger.info("Get a specific Kategorie with id {}",id);
		Kategorie kategorie = mongoDBController.getKategorie(id);
		
		return kategorie;
	}

	@Override
	public List<Kategorie> getKategorien() {
		logger.info("Get all Kategories");
		List<Kategorie> Kategories = mongoDBController.getKategories();
		return Kategories;
	}

	@Override
	public boolean kategorieExists(UUID id) {
		logger.info("Check if Document is existing");
		return mongoDBController.existKategorie(id);
	}

	@Override
	public void saveKategorie(Kategorie kategorie) throws Exception {
		logger.info("Save Kategorie of Entity");
		mongoDBController.insertKategorie(kategorie);
	}

	@Override
	public void updateKategorie(UUID id, Kategorie kategorie) throws Exception {
		logger.info("Update Kategorie of Entity");
		mongoDBController.updateKategorie(id, kategorie);
	}

	@Override
	public void deleteKategorieById(UUID id) {
		logger.info("Delete Kategorie by id");
		mongoDBController.deleteKategorieById(id);
	}

	@Override
	public void deleteAllKategories() {
		logger.info("Delete all Kategories");
		mongoDBController.deleteAllKategories();
	}

}
