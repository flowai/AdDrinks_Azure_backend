package de.addrinks.backend.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.addrinks.backend.azure.MongoDBController;
import de.addrinks.backend.model.Abonnement;
import de.addrinks.backend.model.Bestellung;

public class AbonnementServiceImpl implements AbonnementService {
	public static final Logger logger = LoggerFactory.getLogger(AbonnementServiceImpl.class);
	
	@Autowired
	MongoDBController mongoDBController;
	
	@Override
	public void saveAbonnement(Abonnement abo) throws Exception {
		logger.info("Save Abonnement of Entity");
		mongoDBController.insertAbonnement(abo);
	}

	@Override
	public List<Abonnement> getAbonnements() {
		logger.info("Get all Abonnements");
		List<Abonnement> abonnements = mongoDBController.getAbonnements();
		return abonnements;
	}

	public boolean abonnementExists(UUID id) {
		logger.info("Check if Document is existing");
		return mongoDBController.existAbonnement(id);
	}
}
