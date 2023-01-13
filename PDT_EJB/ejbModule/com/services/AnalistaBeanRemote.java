package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.AccionConstancia;
import com.entities.AccionJustificacion;
import com.entities.AccionReclamo;
import com.entities.Analista;
import com.entities.Usuario;
import com.exception.ServicesException;

@Remote
public interface AnalistaBeanRemote {
	
	void create(Analista analista) throws ServicesException;
	void update(Analista analista) throws ServicesException;
	void drop(Long idAnalista) throws ServicesException;
	void addAccionConstancia(Long idAnalista, AccionConstancia accionConstancia) throws ServicesException;
	void removeAccionConstancia(Long idAnalista, Long idAccionConstancia) throws ServicesException;
	void addAccionJustificacion(Long idAnalista, AccionJustificacion idAccionJustificacion) throws ServicesException;
	void removeAccionJustificacion(Long idAnalista, Long idAccionJustificacion) throws ServicesException;
	void addAccionReclamo(Long idAnalista, AccionReclamo accionReclamo) throws ServicesException;
	void removeAccionReclamo(Long idAnalista, Long idAccionReclamo) throws ServicesException;
	List<Analista> findAll() throws ServicesException;
	Analista find(Long idAnalista) throws ServicesException;
	Analista findForUser(Usuario usuario) throws ServicesException;

}
