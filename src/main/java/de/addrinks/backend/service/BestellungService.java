package de.addrinks.backend.service;

import java.util.List;
import java.util.UUID;

import de.addrinks.backend.model.Bestellung;

public interface BestellungService {

	void saveBestellung(Bestellung bestellung) throws Exception;

	List<Bestellung> getBestellungen();

	boolean bestellungExists(UUID id);

}
