package com.leonardodonato.calendarioeventos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardodonato.calendarioeventos.domain.Usuario;
import com.leonardodonato.calendarioeventos.repositories.UsuarioRepository;
import com.leonardodonato.calendarioeventos.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UsuarioRepository repo;

	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! Id = " + id));
	}
}
