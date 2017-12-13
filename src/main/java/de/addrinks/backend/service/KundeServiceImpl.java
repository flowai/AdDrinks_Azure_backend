package de.addrinks.backend.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.addrinks.backend.azure.MongoDBController;
import de.addrinks.backend.model.Kunde;

public class KundeServiceImpl implements KundeService {
	public static final Logger logger = LoggerFactory.getLogger(KundeServiceImpl.class);
	
	@Autowired
	MongoDBController mongoDBController;


	@Override
	public void saveKunde(Kunde kunde) throws Exception {
		logger.info("Save Kunde of Entity");
		mongoDBController.insertKunde(kunde);
	}

	@Override
	public boolean kundeExists(UUID id) {
		logger.info("Check if Document is existing");
		return mongoDBController.existKunde(id);
	}

}
