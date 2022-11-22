package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.AccionJustificacion;
import com.exception.ServicesException;

/**
 * Session Bean implementation class AccionGeneracionBean
 */
@Stateless
@LocalBean
public class AccionJustificacionBean implements AccionJustificacionBeanRemote {

	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public AccionJustificacionBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(AccionJustificacion accionJustificacion) throws ServicesException {
   		try{
   			em.persist(accionJustificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear la ACCION JUSTIFICACION");
   		}		
   	}

   	@Override
   	public void update(AccionJustificacion accionJustificacion) throws ServicesException {
   		try{
   			em.merge(accionJustificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar la ACCION JUSTIFICACION");
   		}		
   	}

   	@Override
   	public void drop(Long idAccionJustificacion) throws ServicesException {
   		try{
   			AccionJustificacion accionJustificacion = em.find(AccionJustificacion.class, idAccionJustificacion);
   			em.remove(accionJustificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar la ACCION ACCION JUSTIFICACION");
   		}
   	}
   	  	
   	@Override
   	public List<AccionJustificacion> findAll() {
   		TypedQuery<AccionJustificacion> query = em.createQuery("SELECT a FROM AccionJustificacion a",AccionJustificacion.class); 
   		return query.getResultList();
   	}

   	@Override
   	public List<AccionJustificacion> findAll(String filter) {
   		TypedQuery<AccionJustificacion> query = em.createQuery("SELECT a FROM AccionJustificacion a WHERE m.nombre LIKE :nombre",AccionJustificacion.class)
   				.setParameter("nombre", filter); 
   		return query.getResultList();
   	}

	@Override
	public AccionJustificacion find(Long idAccionJustificacion) throws ServicesException {
		try{
			AccionJustificacion accionJustificacion = em.find(AccionJustificacion.class, idAccionJustificacion);
   			return accionJustificacion;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener la ACCION JUSTIFICACION");
   		}
	}

}
