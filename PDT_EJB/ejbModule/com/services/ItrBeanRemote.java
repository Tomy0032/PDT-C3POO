package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Itr;
import com.entities.Usuario;
import com.exception.ServicesException;

@Remote
public interface ItrBeanRemote {
	
	void create(Itr itr) throws ServicesException;
	void update(Itr itr) throws ServicesException;
	void drop(Long idItr) throws ServicesException;
	void addUsuario(Long idItr, Usuario usuario) throws ServicesException;
	void removeUsuario(Long idItr, Long idUsuario) throws ServicesException;
	List<Itr> findAll();
	List<Itr> findAll(String filter);
	Itr find(Long idItr) throws ServicesException;

}
