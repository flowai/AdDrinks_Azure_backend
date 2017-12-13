package de.addrinks.backend.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.addrinks.backend.azure.MongoDBController;
import de.addrinks.backend.model.PunkteProView;

public class PunkteProViewServiceImpl implements PunkteProViewService {
	public static final Logger logger = LoggerFactory.getLogger(PunkteProViewServiceImpl.class);
	
	@Autowired
	MongoDBController mongoDBController;

	@Override
	public boolean ppvExist(UUID id) {
		logger.info("Check if Document is existing");
		return mongoDBController.existPPV(id);
	}

	@Override
	public void savePPV(PunkteProView ppv) throws Exception {
		logger.info("Save PPV of Entity");
		mongoDBController.insertPPV(ppv);
	}

}
