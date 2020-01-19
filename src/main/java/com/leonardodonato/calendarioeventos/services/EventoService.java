package com.leonardodonato.calendarioeventos.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.leonardodonato.calendarioeventos.domain.Evento;
import com.leonardodonato.calendarioeventos.repositories.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository repo;

	public Evento find(Integer id) {
		Optional<Evento> obj = repo.findById(id);
		return obj.orElse(null);
	}

	@Transactional
	public Evento insert(Evento obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Evento update(Evento obj) {
		obj = repo.save(obj);
		return obj;
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			
		}
	}

	public List<Evento> findAll() {
		return repo.findAll();
	}
}
