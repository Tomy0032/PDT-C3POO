package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Responsabilidad;
import com.exception.ServicesException;

@Remote
public interface ResponsabilidadBeanRemote {
	
	void create(Responsabilidad responsabilidad) throws ServicesException;
	void update(Responsabilidad responsabilidad) throws ServicesException;
	void drop(Long idResposabilidad) throws ServicesException;
	List<Responsabilidad> findAll();
	Responsabilidad find(Long idResposabilidad) throws ServicesException;

}
