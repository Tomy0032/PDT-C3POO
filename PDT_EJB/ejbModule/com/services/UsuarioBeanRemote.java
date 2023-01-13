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
	List<Usuario> findAll() throws ServicesException;
	List<Usuario> findAllForDocument(Documento documento) throws ServicesException;
	List<Usuario> findAllForPersonalEmail(String email) throws ServicesException;
	List<Usuario> findAllForInstitutionalEmail(String email) throws ServicesException;
	List<Usuario> findAllForUsername(String nombreUsuario) throws ServicesException;
	List<Usuario> findAllForTelephone(String telefono) throws ServicesException;
	Usuario inicioSesion(String nombreUsuario,String contrasena) throws ServicesException;

	Usuario find(Long idUsuario) throws ServicesException;

}
