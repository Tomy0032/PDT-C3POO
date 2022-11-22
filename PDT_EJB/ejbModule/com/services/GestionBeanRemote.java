package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Gestion;
import com.exception.ServicesException;

@Remote
public interface GestionBeanRemote {
	
	void create(Gestion gestion) throws ServicesException;
	void update(Gestion gestion) throws ServicesException;
	void drop(Long idGestion) throws ServicesException;
	List<Gestion> findAll();
	List<Gestion> findAll(String filter);
	Gestion find(Long idGestion) throws ServicesException;

}
