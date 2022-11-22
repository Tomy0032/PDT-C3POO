package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Genero;
import com.entities.Usuario;
import com.exception.ServicesException;

@Remote
public interface GeneroBeanRemote {
	
	void create(Genero genero) throws ServicesException;
	void update(Genero genero) throws ServicesException;
	void drop(Long idGenero) throws ServicesException;
	void addUsuario(Long idGenero, Usuario usuario) throws ServicesException;
	void removeUsuario(Long idGenero, Long idUsuario) throws ServicesException;
	List<Genero> findAll();
	List<Genero> findAll(String filter);
	Genero find(Long idGenero) throws ServicesException;
	
}
