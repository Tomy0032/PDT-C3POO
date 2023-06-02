package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.TipoTutor;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TipoBean
 */
@Stateless
@LocalBean
public class TipoTutorBean implements TipoTutorBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TipoTutorBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(TipoTutor tipo) throws ServicesException {
   		try{
   			em.persist(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el TIPO DE TUTOR");
   		}		
   	}

   	@Override
   	public void update(TipoTutor tipo) throws ServicesException {
   		try{
   			em.merge(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el TIPO DE TUTOR");
   		}		
   	}

   	@Override
   	public void drop(Long idTipo) throws ServicesException {
   		try{
   			TipoTutor tipo = em.find(TipoTutor.class, idTipo);
   			em.remove(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el TIPO DE TUTOR");
   		}
   	}
   	
   	@Override
   	public void addTutor(Long idTipo, Usuario tutor) throws ServicesException {
   		try{
   			TipoTutor tipo = em.find(TipoTutor.class, idTipo);
   			tipo.getTutores().add(tutor);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar el TUTOR al TIPO DE TUTOR");
   		}		
   	}
   	
   	@Override
   	public void removeTutor(Long idTipo, Long idTutor) throws ServicesException {
   		try{
   			TipoTutor tipo = em.find(TipoTutor.class, idTipo);
   			Usuario tutor = em.find(Usuario.class, idTutor);
   			tipo.getTutores().remove(tutor);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover el TUTOR del TIPO DE TUTOR");
   		}		
   	}
   	
   	@Override
   	public List<TipoTutor> findAll() throws ServicesException {
   		try {
	   		TypedQuery<TipoTutor> query = em.createQuery("SELECT t FROM TipoTutor t",TipoTutor.class); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron TIPOS DE TUTOR");
		}
   	}

   	@Override
   	public List<TipoTutor> findAll(String filter) throws ServicesException {
   		try {
   			TypedQuery<TipoTutor> query = em.createQuery("SELECT t FROM TipoTutor t WHERE t.nombre LIKE :nombre",TipoTutor.class)
	   				.setParameter("nombre", filter); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron TIPOS DE TUTOR con ese NOMBRE");
		}
   	}

	@Override
	public TipoTutor find(Long idTipo) throws ServicesException {
		try{
   			TipoTutor tipo = em.find(TipoTutor.class, idTipo);
   			return tipo;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el TIPO DE TUTOR");
   		}
	}

}
