package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.AccionReclamo;
import com.entities.Reclamo;
import com.exception.ServicesException;

@Remote
public interface ReclamoBeanRemote {
	
	void create(Reclamo Reclamo) throws ServicesException;
	void update(Reclamo Reclamo) throws ServicesException;
	void drop(Long idReclamo) throws ServicesException;
	void addAccionReclamo(Long idReclamo, AccionReclamo reclamo) throws ServicesException;
	void removeAccionReclamo(Long idReclamo, Long idAccionReclamo) throws ServicesException;
	List<Reclamo> findAll();
	List<Reclamo> findAll(String filter);	
	Reclamo find(Long idReclamo) throws ServicesException;

}
