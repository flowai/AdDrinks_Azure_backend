package de.addrinks.backend.service;

import java.util.List;

import de.addrinks.backend.model.Abonnement;

public interface AbonnementService {

	List<Abonnement> getAbonnements();

	void saveAbonnement(Abonnement abo) throws Exception;

}
