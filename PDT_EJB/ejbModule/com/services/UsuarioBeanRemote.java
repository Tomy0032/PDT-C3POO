package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Analista;
import com.entities.Documento;
import com.entities.Estudiante;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServicesException;

@Remote
public interface UsuarioBeanRemote {
	
	void create(Usuario usuario) throws ServicesException;
	void update(Usuario usuario) throws ServicesException;
	void drop(Long idUsuario) throws ServicesException;
	void addAnalista(Long idUsuario, Analista analista) throws ServicesException;
	void removeAnalista(Long idUsuario, Long idAnalista) throws ServicesException;
	void addEstudiante(Long idUsuario, Estudiante estudiante) throws ServicesException;
	void removeEstudiante(Long idUsuario, Long idEstudiante) throws ServicesException;
	void addTutor(Long idUsuario, Tutor tutor) throws ServicesException;
	void removeTutor(Long idUsuario, Long idTutor) throws ServicesException;
	List<Usuario> findAll();
	List<Usuario> findAllForDocument(Documento documento);
	List<Usuario> findAllForPersonalEmail(String email);
	List<Usuario> findAllForInstitutionalEmail(String email);
	List<Usuario> findAllForUsername(String nombreUsuario);
	List<Usuario> findAllForTelephone(String telefono);

	Usuario find(Long idUsuario) throws ServicesException;

}
