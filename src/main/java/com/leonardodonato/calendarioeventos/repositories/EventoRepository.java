package com.leonardodonato.calendarioeventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardodonato.calendarioeventos.domain.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
	
}
