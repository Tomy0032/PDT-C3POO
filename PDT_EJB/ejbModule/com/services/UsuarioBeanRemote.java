package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Documento;
import com.entities.TipoUsuario;
import com.entities.Usuario;
import com.exception.ServicesException;

@Remote
public interface UsuarioBeanRemote {
	
	void create(Usuario usuario) throws ServicesException;
	void update(Usuario usuario) throws ServicesException;
	void drop(Long idUsuario) throws ServicesException;
	List<Usuario> findAll() throws ServicesException;
	List<Usuario> findAllForDocument(Documento documento) throws ServicesException;
	List<Usuario> findAllForPersonalEmail(String email) throws ServicesException;
	List<Usuario> findAllForInstitutionalEmail(String email) throws ServicesException;
	List<Usuario> findAllForUsername(String nombreUsuario) throws ServicesException;
	List<Usuario> findAllForTelephone(String telefono) throws ServicesException;
	List<Usuario> findAllForType(TipoUsuario tipo) throws ServicesException;
	List<Usuario> findAllTutoresEvento(String text) throws ServicesException;
	Usuario inicioSesion(String nombreUsuario,String contrasena) throws ServicesException;

	Usuario find(Long idUsuario) throws ServicesException;

}
