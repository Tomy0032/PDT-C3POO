package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Analista;
import com.entities.Documento;
import com.entities.Estudiante;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
@LocalBean
public class UsuarioBean implements UsuarioBeanRemote {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void create(Usuario usuario) throws ServicesException {
		try{
			em.persist(usuario);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo crear el USUARIO");
		}		
	}

	@Override
	public void update(Usuario usuario) throws ServicesException {
		try{
			em.merge(usuario);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo actualizar el USUARIO");
		}		
	}

	@Override
	public void drop(Long idUsuario) throws ServicesException {
		try{
			Usuario usuario = em.find(Usuario.class, idUsuario);
			em.remove(usuario);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo eliminar el USUARIO");
		}
	}
	
	@Override
	public void addAnalista(Long idUsuario, Analista analista) throws ServicesException {
		try{
			Usuario usuario = em.find(Usuario.class, idUsuario);
			usuario.getAnalistas().add(analista);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar el ANALISTA al USUARIO");
		}		
	}
	
	@Override
	public void removeAnalista(Long idUsuario, Long idAnalista) throws ServicesException {
		try{
			Usuario usuario = em.find(Usuario.class, idUsuario);
			Analista analista = em.find(Analista.class, idAnalista);
			usuario.getAnalistas().remove(analista);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover el ANALISTA del USUARIO");
		}		
	}
	
	@Override
	public void addEstudiante(Long idUsuario, Estudiante estudiante) throws ServicesException {
		try{
			Usuario usuario = em.find(Usuario.class, idUsuario);
			usuario.getEstudiantes().add(estudiante);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar el ESTUDIANTE al USUARIO");
		}		
	}
	
	@Override
	public void removeEstudiante(Long idUsuario, Long idEstudiante) throws ServicesException {
		try{
			Usuario usuario = em.find(Usuario.class, idUsuario);
			Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
			usuario.getEstudiantes().remove(estudiante);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover el ESTUDIANTE del USUARIO");
		}		
	}
	
	@Override
	public void addTutor(Long idUsuario, Tutor tutor) throws ServicesException {
		try{
			Usuario usuario = em.find(Usuario.class, idUsuario);
			usuario.getTutores().add(tutor);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar el TUTOR al USUARIO");
		}		
	}
	
	@Override
	public void removeTutor(Long idUsuario, Long idTutor) throws ServicesException {
		try{
			Usuario usuario = em.find(Usuario.class, idUsuario);
			Tutor tutor = em.find(Tutor.class, idTutor);
			usuario.getTutores().remove(tutor);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover el TUTOR del USUARIO");
		}		
	}

	@Override
	public List<Usuario> findAll() throws ServicesException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u",Usuario.class); 
			return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron USUARIOS");
		}
	}

	@Override
	public List<Usuario> findAllForDocument(Documento documento) throws ServicesException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.documento = :documento",Usuario.class)
					.setParameter("documento", documento); 
			return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron USUARIOS con ese DOCUMENTO");
		}
	}
	
	@Override
	public List<Usuario> findAllForPersonalEmail(String email) throws ServicesException {
		try{
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.correoPersonal LIKE :email",Usuario.class)
					.setParameter("email", email); 
			return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron USUARIOS con ese CORREO PERSONAL");
		}
	}
	
	@Override
	public List<Usuario> findAllForInstitutionalEmail(String email) throws ServicesException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.correoInstitucional LIKE :email",Usuario.class)
					.setParameter("email", email); 
			return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron USUARIOS con ese CORREO INSTITUCIONAL");
		}
	}
	
	@Override
	public List<Usuario> findAllForUsername(String nombreUsuario) throws ServicesException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario LIKE :nombreUsuario",Usuario.class)
					.setParameter("nombreUsuario", nombreUsuario); 
			return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron USUARIOS con ese NOMBRE DE USUARIO");
		}
	}
	
	@Override
	public List<Usuario> findAllForTelephone(String telefono) throws ServicesException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.telefono LIKE :telefono",Usuario.class)
					.setParameter("telefono", telefono); 
			return query.getResultList();
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontraron USUARIOS con ese TELEFONO");
	}
	}

	@Override
	public Usuario find(Long idUsuario) throws ServicesException {
		try{
			Usuario usuario = em.find(Usuario.class, idUsuario);
			return usuario;
		}catch(Exception e){
			throw new ServicesException("No se pudo obtener el USUARIO");
		}
	}

	@Override
	public Usuario inicioSesion(String nombreUsuario, String contrasena) throws ServicesException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario LIKE :nombreUsuario AND u.contrasena LIKE :contrasena",Usuario.class)
					.setParameter("nombreUsuario", nombreUsuario)
					.setParameter("contrasena", contrasena); 
			return query.getResultList().get(0);
		}catch(Exception e) {
			throw new ServicesException("No se encontraron USUARIOS con esas CREDENCIALES");
		}
	}
    
}
