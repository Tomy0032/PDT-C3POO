package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Constancia;
import com.entities.ConvocatoriaAsistencia;
import com.entities.Estudiante;
import com.entities.Generacion;
import com.entities.Justificacion;
import com.entities.Usuario;
import com.exception.ServicesException;

@Remote
public interface EstudianteBeanRemote {
	
	void create(Estudiante estudiante) throws ServicesException;
	void update(Estudiante estudiante) throws ServicesException;
	void drop(Long idEstudiante) throws ServicesException;
	void addConstancia(Long idEstudiante, Constancia constancia) throws ServicesException;
	void removeConstancia(Long idEstudiante, Long idConstancia) throws ServicesException;
	void addJustificacion(Long idEstudiante, Justificacion justificacion) throws ServicesException;
	void removeJustificacion(Long idEstudiante, Long idJustificacion) throws ServicesException;
	void addConvocatoriaAsistencia(Long idEstudiante, ConvocatoriaAsistencia convocatoriaAsistencia) throws ServicesException;
	void removeConvocatoriaAsistencia(Long idEstudiante, Long idConvicatoriaAsistencia) throws ServicesException;
	List<Estudiante> findAll() throws ServicesException;
	List<Estudiante> findAllForGeneracion(Generacion generacion) throws ServicesException;
	Estudiante find(Long idEstudiante) throws ServicesException;
	Estudiante findForUser(Usuario usuario) throws ServicesException;

}
