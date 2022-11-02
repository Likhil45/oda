package com.oda.odyssey.service;

import java.util.List;

import com.oda.odyssey.model.Pirate;

public interface PirateService {
	Pirate savePirate(Pirate pirate);
	List<Pirate> getAllPirates();
	Pirate getPirateById(long id);
	Pirate updatePirate(Pirate pirate, long id);
	void deletePirate(long id);

}
