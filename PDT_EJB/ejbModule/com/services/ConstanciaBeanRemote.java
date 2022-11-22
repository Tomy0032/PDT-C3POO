package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Constancia;
import com.entities.AccionConstancia;
import com.exception.ServicesException;

@Remote
public interface ConstanciaBeanRemote {

	void create(Constancia constancia) throws ServicesException;
	void update(Constancia constancia) throws ServicesException;
	void drop(Long idConstancia) throws ServicesException;
	void addAccionConstancia(Long idConstancia, AccionConstancia reclamo) throws ServicesException;
	void removeAccionConstancia(Long idConstancia, Long idAccionConstancia) throws ServicesException;
	List<Constancia> findAll();
	List<Constancia> findAll(String filter);	
	Constancia find(Long idConstancia) throws ServicesException;
	
}
