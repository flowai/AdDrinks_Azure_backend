package de.addrinks.backend.service;

import java.util.UUID;

import de.addrinks.backend.model.Kunde;

public interface KundeService {

	void saveKunde(Kunde kunde) throws Exception;

	boolean kundeExists(UUID id);

}
