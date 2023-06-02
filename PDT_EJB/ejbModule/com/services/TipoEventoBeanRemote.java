package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.TipoEvento;
import com.entities.Evento;
import com.exception.ServicesException;

@Remote
public interface TipoEventoBeanRemote {
	
	void create(TipoEvento tipo) throws ServicesException;
	void update(TipoEvento tipo) throws ServicesException;
	void drop(Long idTipo) throws ServicesException;
	void addEvento(Long idTipo, Evento evento) throws ServicesException;
	void removeEvento(Long idTipo, Long idEvento) throws ServicesException;
	List<TipoEvento> findAll() throws ServicesException;
	List<TipoEvento> findAll(String filter) throws ServicesException;
	TipoEvento find(Long idTipo) throws ServicesException;
	
}
