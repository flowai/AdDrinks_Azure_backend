package de.addrinks.backend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.addrinks.backend.azure.MongoDBController;
import de.addrinks.backend.model.Bestellung;
import de.addrinks.backend.model.Kategorie;

@Service
public class BestellungServiceImpl implements BestellungService {
	public static final Logger logger = LoggerFactory.getLogger(KategorieServiceImpl.class);
	
	@Autowired
	MongoDBController mongoDBController;
	
	@Override
	public void saveBestellung(Bestellung bestellung) throws Exception {
		logger.info("Save Kategorie of Entity");
		mongoDBController.insertBestellung(bestellung);
	}

	@Override
	public List<Bestellung> getBestellungen() {
		logger.info("Get all Bestellungen");
		List<Bestellung> Bestellungen = mongoDBController.getBestellungen();
		return Bestellungen;
	}

}
