package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ConvocatoriaAsistencia;
import com.exception.ServicesException;

/**
 * Session Bean implementation class ConvocatoriaAsistenciaBean
 */
@Stateless
@LocalBean
public class ConvocatoriaAsistenciaBean implements ConvocatoriaAsistenciaBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ConvocatoriaAsistenciaBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(ConvocatoriaAsistencia convocatoriaAsistencia) throws ServicesException {
   		try{
   			em.persist(convocatoriaAsistencia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear la CONVOCATORIA ASISTENCIA");
   		}		
   	}

   	@Override
   	public void update(ConvocatoriaAsistencia convocatoriaAsistencia) throws ServicesException {
   		try{
   			em.merge(convocatoriaAsistencia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar la CONVOCATORIA ASISTENCIA");
   		}		
   	}

   	@Override
   	public void drop(Long idConvocatoriaAsistencia) throws ServicesException {
   		try{
   			ConvocatoriaAsistencia convocatoriaAsistencia = em.find(ConvocatoriaAsistencia.class, idConvocatoriaAsistencia);
   			em.remove(convocatoriaAsistencia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar la CONVOCATORIA ASISTENCIA");
   		}
   	}
   	
   	@Override
   	public List<ConvocatoriaAsistencia> findAll() {
   		TypedQuery<ConvocatoriaAsistencia> query = em.createQuery("SELECT c FROM ConvocatoriaAsistencia c",ConvocatoriaAsistencia.class); 
   		return query.getResultList();
   	}

   	@Override
   	public List<ConvocatoriaAsistencia> findAll(String filter) {
   		TypedQuery<ConvocatoriaAsistencia> query = em.createQuery("SELECT c FROM ConvocatoriaAsistencia c WHERE m.nombre LIKE :nombre",ConvocatoriaAsistencia.class)
   				.setParameter("nombre", filter); 
   		return query.getResultList();
   	}

	@Override
	public ConvocatoriaAsistencia find(Long idConvocatoriaAsistencia) throws ServicesException {
		try{
   			ConvocatoriaAsistencia convocatoriaAsistencia = em.find(ConvocatoriaAsistencia.class, idConvocatoriaAsistencia);
   			return convocatoriaAsistencia;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener la CONVOCATORIA ASISTENCIA");
   		}
	}

}
