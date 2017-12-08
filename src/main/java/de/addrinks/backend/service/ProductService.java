package de.addrinks.backend.service;

import java.util.List;
import java.util.UUID;

import de.addrinks.backend.model.Produkt;

public interface ProductService {
	
	Produkt getProdukt(UUID id);

	List<Produkt> getProdukts();

	boolean produktExist(UUID id);

	void saveProdukt(Produkt produkt) throws Exception;

	void updateProdukt(UUID id, Produkt produkt) throws Exception;

	long[] produktBulkExist(List<Produkt> produkts);

	void saveProduktBulk(List<Produkt> produkts);

	void updateProduktBulk(List<Produkt> produkts);

	void deleteProduktById(UUID id);

	void deleteAllProdukts();
}
