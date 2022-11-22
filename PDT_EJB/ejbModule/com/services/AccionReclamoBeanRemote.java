package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.AccionReclamo;
import com.exception.ServicesException;

@Remote
public interface AccionReclamoBeanRemote {

	void create(AccionReclamo accionReclamo) throws ServicesException;
	void update(AccionReclamo accionReclamo) throws ServicesException;
	void drop(Long idAccionReclamo) throws ServicesException;
	List<AccionReclamo> findAll();
	List<AccionReclamo> findAll(String filter);
	AccionReclamo find(Long idAccionReclamo) throws ServicesException;
	
}
