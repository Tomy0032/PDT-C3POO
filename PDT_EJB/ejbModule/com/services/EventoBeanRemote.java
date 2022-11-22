package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Constancia;
import com.entities.ConvocatoriaAsistencia;
import com.entities.Evento;
import com.entities.Gestion;
import com.entities.Justificacion;
import com.entities.Reclamo;
import com.entities.Responsabilidad;
import com.exception.ServicesException;

@Remote
public interface EventoBeanRemote {

	void create(Evento evento) throws ServicesException;
	void update(Evento evento) throws ServicesException;
	void drop(Long idEvento) throws ServicesException;
	void addConstancia(Long idEvento, Constancia constancia) throws ServicesException;
	void removeConstancia(Long idEvento, Long idConstancia) throws ServicesException;
	void addConvocatoriaAsistencia(Long idEvento, ConvocatoriaAsistencia convocatoriaAsistencia) throws ServicesException;
	void removeConvocatoriaAsistencia(Long idEvento, Long idConvicatoriaAsistencia) throws ServicesException;
	void addGestion(Long idEvento, Gestion gestion) throws ServicesException;
	void removeGestion(Long idEvento, Long idGestion) throws ServicesException;
	void addJustificacion(Long idEvento, Justificacion justificacion) throws ServicesException;
	void removeJustificacion(Long idEvento, Long idJustificacion) throws ServicesException;
	void addReclamo(Long idEvento, Reclamo reclamo) throws ServicesException;
	void removeReclamo(Long idEvento, Long idReclamo) throws ServicesException;
	void addResponsabilidad(Long idEvento, Responsabilidad responsabilidad) throws ServicesException;
	void removeResponsabilidad(Long idEvento, Long idResponsabilidad) throws ServicesException;
	List<Evento> findAll();
	List<Evento> findAll(String filter);
	Evento find(Long idEvento) throws ServicesException;
	
}
