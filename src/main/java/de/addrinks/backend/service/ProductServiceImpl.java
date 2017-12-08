package de.addrinks.backend.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.addrinks.backend.azure.MongoDBController;
import de.addrinks.backend.model.Produkt;
import de.addrinks.backend.model.User;

@Service
public class ProductServiceImpl implements ProductService {
	public static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	MongoDBController mongoDBController;
	
	@Override
	public Produkt getProdukt(UUID id) {
		logger.info("Get a specific Produkt with id {}",id);
		Produkt produkt = mongoDBController.getProdukt(id);
		
		return produkt;
	}

	@Override
	public List<Produkt> getProdukts() {
		logger.info("Get all Produkts");
		List<Produkt> produkts = mongoDBController.getProdukts();
		return produkts;
	}

	@Override
	public boolean produktExist(UUID id) {
		logger.info("Check if Document is existing");
		return mongoDBController.existProdukt(id);
	}

	@Override
	public void saveProdukt(Produkt produkt) throws Exception {
		logger.info("Save Produkt of Entity");
		mongoDBController.insertProdukt(produkt);
	}

	@Override
	public void updateProdukt(UUID id, Produkt produkt) throws Exception {
		logger.info("Update Produkt of Entity");
		mongoDBController.updateProdukt(id, produkt);
	}

	@Override
	public long[] produktBulkExist(List<Produkt> produkts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveProduktBulk(List<Produkt> produkts) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduktBulk(List<Produkt> produkts) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduktById(UUID id) {
		logger.info("Delete produkt by id");
		mongoDBController.deleteProduktById(id);
	}

	@Override
	public void deleteAllProdukts() {
		logger.info("Delete all Produkts");
		mongoDBController.deleteAllProdukts();
	}

}
