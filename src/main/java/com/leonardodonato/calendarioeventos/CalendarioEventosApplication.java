package com.leonardodonato.calendarioeventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.leonardodonato.calendarioeventos.domain.Usuario;
import com.leonardodonato.calendarioeventos.repositories.UsuarioRepository;

@SpringBootApplication
public class CalendarioEventosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CalendarioEventosApplication.class, args);
	}
	
	@Autowired
	UsuarioRepository repo;
	
	@Autowired
	BCryptPasswordEncoder pe;

	@Override
	public void run(String... args) throws Exception {
		Usuario user1 = new Usuario(null, "user1@gmail.com", pe.encode("123456"), "Usuario 1");
		repo.save(user1);
		Usuario user2 = new Usuario(null, "user2@gmail.com", pe.encode("123456"), "Usuario 2");
		repo.save(user2);
	}
	
	

}
