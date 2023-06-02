package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.TipoUsuario;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TipoBean
 */
@Stateless
@LocalBean
public class TipoUsuarioBean implements TipoUsuarioBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TipoUsuarioBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(TipoUsuario tipo) throws ServicesException {
   		try{
   			em.persist(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el TIPO DE USUARIO");
   		}		
   	}

   	@Override
   	public void update(TipoUsuario tipo) throws ServicesException {
   		try{
   			em.merge(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el TIPO DE USUARIO");
   		}		
   	}

   	@Override
   	public void drop(Long idTipo) throws ServicesException {
   		try{
   			TipoUsuario tipo = em.find(TipoUsuario.class, idTipo);
   			em.remove(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el TIPO DE USUARIO");
   		}
   	}
   	
   	@Override
   	public void addTutor(Long idTipo, Usuario usuario) throws ServicesException {
   		try{
   			TipoUsuario tipo = em.find(TipoUsuario.class, idTipo);
   			tipo.getUsuarios().add(usuario);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar el USUARIO al TIPO");
   		}		
   	}
   	
   	@Override
   	public void removeTutor(Long idTipo, Long idUsuario) throws ServicesException {
   		try{
   			TipoUsuario tipo = em.find(TipoUsuario.class, idTipo);
   			Usuario tutor = em.find(Usuario.class, idUsuario);
   			tipo.getUsuarios().remove(tutor);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover el USUARIO del TIPO");
   		}		
   	}
   	
   	@Override
   	public List<TipoUsuario> findAll() throws ServicesException {
   		try {
	   		TypedQuery<TipoUsuario> query = em.createQuery("SELECT t FROM TipoUsuario t",TipoUsuario.class); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron TIPOS DE USUARIO");
		}
   	}

   	@Override
   	public List<TipoUsuario> findAll(String filter) throws ServicesException {
   		try {
   			TypedQuery<TipoUsuario> query = em.createQuery("SELECT t FROM TipoUsuario t WHERE t.nombre LIKE :nombre",TipoUsuario.class)
	   				.setParameter("nombre", filter); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron TIPOS DE USUARIO con ese NOMBRE");
		}
   	}

	@Override
	public TipoUsuario find(Long idTipo) throws ServicesException {
		try{
			TipoUsuario tipo = em.find(TipoUsuario.class, idTipo);
   			return tipo;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el TIPO DE USUARIO");
   		}
	}

}
