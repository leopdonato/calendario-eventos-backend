package com.leonardodonato.calendarioeventos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardodonato.calendarioeventos.domain.Evento;
import com.leonardodonato.calendarioeventos.domain.Usuario;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
	List<Evento> findByUsuario(Usuario user);
}
