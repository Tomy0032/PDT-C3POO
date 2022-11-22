package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.AccionConstancia;
import com.exception.ServicesException;

@Remote
public interface AccionConstanciaBeanRemote {

	void create(AccionConstancia accionConstancia) throws ServicesException;
	void update(AccionConstancia accionConstancia) throws ServicesException;
	void drop(Long idAccionConstancia) throws ServicesException;
	List<AccionConstancia> findAll();
	List<AccionConstancia> findAll(String filter);
	AccionConstancia find(Long idAccionConstancia) throws ServicesException;
	
}
