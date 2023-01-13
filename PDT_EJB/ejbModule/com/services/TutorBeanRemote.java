package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Area;
import com.entities.Responsabilidad;
import com.entities.Tipo;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServicesException;

@Remote
public interface TutorBeanRemote {
	
	void create(Tutor tutor) throws ServicesException;
	void update(Tutor tutor) throws ServicesException;
	void drop(Long idTutor) throws ServicesException;
	void addResponsabilidad(Long idTutor, Responsabilidad responsabilidad) throws ServicesException;
	void removeResponsabilidad(Long idTutor, Long idResposabilidad) throws ServicesException;
	List<Tutor> findAll() throws ServicesException;
	List<Tutor> findAllForArea(Area area) throws ServicesException;
	List<Tutor> findAllForTipo(Tipo tipo) throws ServicesException;
	Tutor find(Long idAnalista) throws ServicesException;
	Tutor findForUser(Usuario usuario) throws ServicesException;	

}
