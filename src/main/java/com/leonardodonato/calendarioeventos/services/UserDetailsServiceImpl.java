package com.leonardodonato.calendarioeventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leonardodonato.calendarioeventos.domain.Usuario;
import com.leonardodonato.calendarioeventos.repositories.UsuarioRepository;
import com.leonardodonato.calendarioeventos.security.UserSescurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario cli = repo.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSescurity(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}

}
