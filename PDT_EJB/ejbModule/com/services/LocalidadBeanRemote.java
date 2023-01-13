package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Localidad;
import com.entities.Usuario;
import com.entities.Itr;
import com.exception.ServicesException;

@Remote
public interface LocalidadBeanRemote {
	
	void create(Localidad localidad) throws ServicesException;
	void update(Localidad localidad) throws ServicesException;
	void drop(Long idLocalidad) throws ServicesException;
	void addItr(Long idLocalidad, Itr itr) throws ServicesException;
	void removeItr(Long idLocalidad, Long idItr) throws ServicesException;
	void addUsuario(Long idLocalidad, Usuario usuario) throws ServicesException;
	void removeUsuario(Long idLocalidad, Long idUsuario) throws ServicesException;
	List<Localidad> findAll() throws ServicesException;
	List<Localidad> findAll(String filter) throws ServicesException;
	Localidad find(Long idLocalidad) throws ServicesException;

}
