package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.AccionJustificacion;
import com.entities.Justificacion;
import com.exception.ServicesException;

/**
 * Session Bean implementation class JustificacionBean
 */
@Stateless
@LocalBean
public class JustificacionBean implements JustificacionBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public JustificacionBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Justificacion Justificacion) throws ServicesException {
   		try{
   			em.persist(Justificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear la JUSTIFICACION");
   		}		
   	}

   	@Override
   	public void update(Justificacion Justificacion) throws ServicesException {
   		try{
   			em.merge(Justificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar la JUSTIFICACION");
   		}		
   	}

   	@Override
   	public void drop(Long idJustificacion) throws ServicesException {
   		try{
   			Justificacion Justificacion = em.find(Justificacion.class, idJustificacion);
   			em.remove(Justificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar la JUSTIFICACION");
   		}
   	}
   	
   	@Override
   	public void addAccionJustificacion(Long idJustificacion, AccionJustificacion accionJustificacion) throws ServicesException {
   		try{
   			Justificacion Justificacion = em.find(Justificacion.class, idJustificacion);
   			Justificacion.getAccionesJustificaciones().add(accionJustificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar la ACCION JUSTIFICACION al la JUSTIFICACION");
   		}		
   	}
   	
   	@Override
   	public void removeAccionJustificacion(Long idJustificacion, Long idAccionJustificacion) throws ServicesException {
   		try{
   			Justificacion Justificacion = em.find(Justificacion.class, idJustificacion);
   			AccionJustificacion accionJustificacion = em.find(AccionJustificacion.class, idAccionJustificacion);
   			Justificacion.getAccionesJustificaciones().remove(accionJustificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover la ACCION JUSTIFICACION de la JUSTIFICACION");
   		}		
   	}

   	@Override
   	public List<Justificacion> findAll() {
   		TypedQuery<Justificacion> query = em.createQuery("SELECT j FROM Justificacion j",Justificacion.class); 
   		return query.getResultList();
   	}

   	@Override
   	public List<Justificacion> findAll(String filter) {
   		TypedQuery<Justificacion> query = em.createQuery("SELECT j FROM Justificacion j WHERE j.nombre LIKE :nombre",Justificacion.class)
   				.setParameter("nombre", filter); 
   		return query.getResultList();
   	}

	@Override
	public Justificacion find(Long idJustificacion) throws ServicesException {
		try{
   			Justificacion Justificacion = em.find(Justificacion.class, idJustificacion);
   			return Justificacion;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener la JUSTIFICACION");
   		}
	}

}
