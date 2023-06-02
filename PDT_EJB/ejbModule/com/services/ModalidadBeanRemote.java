package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Modalidad;
import com.entities.Evento;
import com.exception.ServicesException;

@Remote
public interface ModalidadBeanRemote {
	
	void create(Modalidad modalidad) throws ServicesException;
	void update(Modalidad modalidad) throws ServicesException;
	void drop(Long idModalidad) throws ServicesException;
	void addEvento(Long idModalidad, Evento evento) throws ServicesException;
	void removeEvento(Long idModalidad, Long idEvento) throws ServicesException;
	List<Modalidad> findAll() throws ServicesException;
	List<Modalidad> findAll(String filter) throws ServicesException;
	Modalidad find(Long idModalidad) throws ServicesException;
	
}
