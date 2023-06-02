package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.TipoTutor;
import com.entities.Usuario;
import com.exception.ServicesException;

@Remote
public interface TipoTutorBeanRemote {
	
	void create(TipoTutor tipo) throws ServicesException;
	void update(TipoTutor tipo) throws ServicesException;
	void drop(Long idTipo) throws ServicesException;
	void addTutor(Long idTipo, Usuario tutor) throws ServicesException;
	void removeTutor(Long idTipo, Long idTutor) throws ServicesException;
	List<TipoTutor> findAll() throws ServicesException;
	List<TipoTutor> findAll(String filter) throws ServicesException;
	TipoTutor find(Long idTipo) throws ServicesException;
	
}
