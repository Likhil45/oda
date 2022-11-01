package com.oda.odyssey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oda.odyssey.model.Pirate;

public interface PirateRepository extends JpaRepository<Pirate, Long> {

}
