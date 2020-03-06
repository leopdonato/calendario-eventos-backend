package com.leonardodonato.calendarioeventos.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.leonardodonato.calendarioeventos.domain.Evento;
import com.leonardodonato.calendarioeventos.domain.Usuario;
import com.leonardodonato.calendarioeventos.repositories.EventoRepository;
import com.leonardodonato.calendarioeventos.security.UserSecurity;
import com.leonardodonato.calendarioeventos.services.exceptions.DataIntegrityException;
import com.leonardodonato.calendarioeventos.services.exceptions.ObjectNotFoundException;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repo;
	@Autowired
	private UserService userService;

	public Evento find(Integer id) {
		Optional<Evento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Evento não encontrado! Id = " + id));
	}

	@Transactional
	public Evento insert(Evento obj) {
		UserSecurity userSecurity = UserSecurityService.authenticated();
		Usuario user = userService.find(userSecurity.getId());
		obj.setId(null);
		obj.setUsuario(user);
		obj = repo.save(obj);
		return obj;
	}

	public Evento update(Evento obj) {
		Evento evento = find(obj.getId());
		obj.setUsuario(evento.getUsuario());
		obj = repo.save(obj);
		return obj;
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há usuários relacionados");
		}
	}

	public List<Evento> findAll() {
		UserSecurity userSecurity = UserSecurityService.authenticated();
		Usuario user = userService.find(userSecurity.getId());
		return repo.findByUsuario(user);
	}
}
