package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Documento;
import com.exception.ServicesException;

@Remote
public interface DocumentoBeanRemote {
	
	void create(Documento documento) throws ServicesException;
	void update(Documento documento) throws ServicesException;
	void drop(Long idDocumento) throws ServicesException;
	List<Documento> findAll();
	List<Documento> findAll(String filter);	
	Documento find(Long idDocumento) throws ServicesException;

}
