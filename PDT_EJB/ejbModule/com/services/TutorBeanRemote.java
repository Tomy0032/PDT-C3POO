package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Responsabilidad;
import com.entities.Tutor;
import com.exception.ServicesException;

@Remote
public interface TutorBeanRemote {
	
	void create(Tutor tutor) throws ServicesException;
	void update(Tutor tutor) throws ServicesException;
	void drop(Long idTutor) throws ServicesException;
	void addResponsabilidad(Long idTutor, Responsabilidad responsabilidad) throws ServicesException;
	void removeResponsabilidad(Long idTutor, Long idResposabilidad) throws ServicesException;
	List<Tutor> findAll();
	List<Tutor> findAll(String filter);
	Tutor find(Long idAnalista) throws ServicesException;

}
