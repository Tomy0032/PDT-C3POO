package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Pais;
import com.exception.ServicesException;

@Remote
public interface PaisBeanRemote {

	void create(Pais pais) throws ServicesException;
	void update(Pais pais) throws ServicesException;
	void drop(Long idPais) throws ServicesException;
	List<Pais> findAll() throws ServicesException;
	List<Pais> findAll(String filter) throws ServicesException;
	Pais find(Long idPais) throws ServicesException;
	
}
