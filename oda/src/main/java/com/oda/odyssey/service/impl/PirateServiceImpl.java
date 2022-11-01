package com.oda.odyssey.service.impl;

import org.springframework.stereotype.Service;

import com.oda.odyssey.model.Pirate;
import com.oda.odyssey.repository.PirateRepository;
import com.oda.odyssey.service.PirateService;

@Service
public class PirateServiceImpl implements PirateService {
	private PirateRepository pirateRepository;
	

	public PirateServiceImpl(PirateRepository pirateRepository) {
		super();
		this.pirateRepository = pirateRepository;
	}


	@Override
	public Pirate savePirate(Pirate pirate) {
		// TODO Auto-generated method stub
		return pirateRepository.save(pirate);
	}
	

}
