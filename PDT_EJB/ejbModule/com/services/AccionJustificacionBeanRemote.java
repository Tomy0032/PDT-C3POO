package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.AccionJustificacion;
import com.exception.ServicesException;

@Remote
public interface AccionJustificacionBeanRemote {
	
	void create(AccionJustificacion accionJustificacion) throws ServicesException;
	void update(AccionJustificacion accionJustificacion) throws ServicesException;
	void drop(Long idAccionJustificacion) throws ServicesException;
	List<AccionJustificacion> findAll();
	List<AccionJustificacion> findAll(String filter);
	AccionJustificacion find(Long idAccionJustificacion) throws ServicesException;

}
