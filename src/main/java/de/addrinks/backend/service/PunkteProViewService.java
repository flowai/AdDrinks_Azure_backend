package de.addrinks.backend.service;

import java.util.UUID;

import de.addrinks.backend.model.PunkteProView;

public interface PunkteProViewService {

	boolean ppvExist(UUID id);

	void savePPV(PunkteProView ppv) throws Exception;

}
