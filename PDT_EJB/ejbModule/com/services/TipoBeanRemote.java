package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Tipo;
import com.entities.Tutor;
import com.exception.ServicesException;

@Remote
public interface TipoBeanRemote {
	
	void create(Tipo tipo) throws ServicesException;
	void update(Tipo tipo) throws ServicesException;
	void drop(Long idTipo) throws ServicesException;
	void addTutor(Long idTipo, Tutor tutor) throws ServicesException;
	void removeTutor(Long idTipo, Long idTutor) throws ServicesException;
	List<Tipo> findAll();
	List<Tipo> findAll(String filter);
	Tipo tipo(Long idTipo) throws ServicesException;
	
}
