package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Area;
import com.entities.Tutor;
import com.exception.ServicesException;

@Remote
public interface AreaBeanRemote {
	
	void create(Area area) throws ServicesException;
	void update(Area area) throws ServicesException;
	void drop(Long idArea) throws ServicesException;
	void addTutor(Long idArea, Tutor tutor) throws ServicesException;
	void removeTutor(Long idArea, Long idTutor) throws ServicesException;
	List<Area> findAll() throws ServicesException;
	List<Area> findAll(String filter) throws ServicesException;
	Area find(Long idArea) throws ServicesException;

}
