package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Departamento;
import com.entities.Localidad;
import com.exception.ServicesException;

@Remote
public interface DepartamentoBeanRemote {

	void create(Departamento departamento) throws ServicesException;
	void update(Departamento departamento) throws ServicesException;
	void drop(Long idDepartamento) throws ServicesException;
	void addLocalidad(Long idDepartamento, Localidad localidad) throws ServicesException;
	void removeLocalidad(Long idDepartamento, Long idLocalidad) throws ServicesException;
	List<Departamento> findAll() throws ServicesException;
	List<Departamento> findAll(String filter) throws ServicesException;
	Departamento find(Long idDepartamento) throws ServicesException;
	
}
