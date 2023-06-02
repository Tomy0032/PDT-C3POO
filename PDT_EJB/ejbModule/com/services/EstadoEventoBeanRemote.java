package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.EstadoEvento;
import com.entities.Evento;
import com.exception.ServicesException;

@Remote
public interface EstadoEventoBeanRemote {
	
	void create(EstadoEvento estado) throws ServicesException;
	void update(EstadoEvento estado) throws ServicesException;
	void drop(Long idEstado) throws ServicesException;
	void addEvento(Long idEstado, Evento evento) throws ServicesException;
	void removeEvento(Long idEstado, Long idEvento) throws ServicesException;
	List<EstadoEvento> findAll() throws ServicesException;
	List<EstadoEvento> findAll(String filter) throws ServicesException;
	EstadoEvento find(Long idEstado) throws ServicesException;
	
}
