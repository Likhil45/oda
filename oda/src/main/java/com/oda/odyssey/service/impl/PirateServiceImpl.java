package com.oda.odyssey.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oda.odyssey.exception.ResourceNotFoundException;
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


	@Override
	public List<Pirate> getAllPirates(){
		return pirateRepository.findAll();
	}


	@Override
	public Pirate getPirateById(long id) {
		Optional<Pirate> pirate= pirateRepository.findById(id);
		if(pirate.isPresent()) {
			return pirate.get();
		}
		else {
			throw new ResourceNotFoundException("Pirate","Id",id);
		}
	}


	@Override
	public Pirate updatePirate(Pirate pirate, long id) {
		Pirate existingPirate =pirateRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Pirate","id",id));
		existingPirate.setFirstName(pirate.getFirstName());
		existingPirate.setLastName(pirate.getLastName());
		existingPirate.setEmail(pirate.getEmail());
		//Save to DB
		pirateRepository.save(existingPirate);
		return existingPirate;
	}


	@Override
	public void deletePirate(@PathVariable("id")long id) {
		pirateRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Pirate","Id",id));
		pirateRepository.deleteById(id);		
	}
	

}
