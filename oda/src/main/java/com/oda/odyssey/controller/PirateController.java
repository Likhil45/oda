package com.oda.odyssey.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oda.odyssey.exception.ResourceNotFoundException;
import com.oda.odyssey.model.Pirate;
import com.oda.odyssey.repository.PirateRepository;
import com.oda.odyssey.service.PirateService;

@RestController
@RequestMapping("/api/pirates")
public class PirateController {
	private PirateService pirateService;

	public PirateController(PirateService pirateService) {
		super();
		this.pirateService = pirateService;
	}

	// build create pirate REST API
	@PostMapping()
	public ResponseEntity<Pirate> savePirate(@RequestBody Pirate pirate) {
		return new ResponseEntity<Pirate>(pirateService.savePirate(pirate), HttpStatus.CREATED);

	}

	// build get all pirates REST API
	@GetMapping()
	public List<Pirate> getAllPirates() {
		return pirateService.getAllPirates();
	}

	// build get pirate by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Pirate> getPiratesById(@PathVariable("id") long id) {
		return new ResponseEntity<Pirate>(pirateService.getPirateById(id), HttpStatus.OK);
	}

	// build update pirate REST API
	@PutMapping("{id}")
	public ResponseEntity<Pirate> updatePirate(@PathVariable("id") long id, @RequestBody Pirate pirate) {
		return new ResponseEntity<Pirate>(pirateService.updatePirate(pirate, id), HttpStatus.OK);
	}

	// build delete pirate API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePirate(@PathVariable("id") long id) {
		pirateService.deletePirate(id);
		return new ResponseEntity<String>("Pirate Deleted Successfully", HttpStatus.OK);
	}
}
