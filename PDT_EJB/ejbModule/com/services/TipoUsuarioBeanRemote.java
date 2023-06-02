package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.TipoUsuario;
import com.entities.Usuario;
import com.exception.ServicesException;

@Remote
public interface TipoUsuarioBeanRemote {
	
	void create(TipoUsuario tipo) throws ServicesException;
	void update(TipoUsuario tipo) throws ServicesException;
	void drop(Long idTipo) throws ServicesException;
	void addTutor(Long idTipo, Usuario usuario) throws ServicesException;
	void removeTutor(Long idTipo, Long idUsuario) throws ServicesException;
	List<TipoUsuario> findAll() throws ServicesException;
	List<TipoUsuario> findAll(String filter) throws ServicesException;
	TipoUsuario find(Long idTipo) throws ServicesException;
	
}
