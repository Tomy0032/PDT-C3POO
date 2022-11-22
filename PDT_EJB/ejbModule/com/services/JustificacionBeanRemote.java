package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.AccionJustificacion;
import com.entities.Justificacion;
import com.exception.ServicesException;

@Remote
public interface JustificacionBeanRemote {
	
	void create(Justificacion Justificacion) throws ServicesException;
	void update(Justificacion Justificacion) throws ServicesException;
	void drop(Long idJustificacion) throws ServicesException;
	void addAccionJustificacion(Long idJustificacion, AccionJustificacion Justificacion) throws ServicesException;
	void removeAccionJustificacion(Long idJustificacion, Long idAccionJustificacion) throws ServicesException;
	List<Justificacion> findAll();
	List<Justificacion> findAll(String filter);	
	Justificacion find(Long idJustificacion) throws ServicesException;

}
