package com.oda.odyssey.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oda.odyssey.model.Pirate;
import com.oda.odyssey.service.PirateService;

@RestController
@RequestMapping("/api/pirates")
public class PirateController {
	private PirateService pirateService;

	public PirateController(PirateService pirateService) {
		super();
		this.pirateService = pirateService;
	}
	//build create employee REST API
	@PostMapping()
	public ResponseEntity<Pirate> savePirate(@RequestBody Pirate pirate){
		return new ResponseEntity<Pirate>(pirateService.savePirate(pirate),HttpStatus.CREATED);
		
	}

}
