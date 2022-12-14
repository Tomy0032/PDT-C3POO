package com.services;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Remote;

import com.entities.Estudiante;
import com.entities.Generacion;
import com.exception.ServicesException;

@Remote
public interface GeneracionBeanRemote {
	
	void create(Generacion generacion) throws ServicesException;
	void update(Generacion generacion) throws ServicesException;
	void drop(Long idGeneracion) throws ServicesException;
	void addEstudiante(Long idGeneracion, Estudiante Generacion) throws ServicesException;
	void removeEstudiante(Long idGeneracion, Long idEstudiante) throws ServicesException;
	List<Generacion> findAll();
	List<Generacion> findAllForName(String filter);
	List<Generacion> findAllForYear(BigDecimal filter);	
	Generacion find(Long idGeneracion) throws ServicesException;

}
