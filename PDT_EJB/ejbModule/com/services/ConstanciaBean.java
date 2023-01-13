package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.AccionConstancia;
import com.entities.Constancia;
import com.exception.ServicesException;

/**
 * Session Bean implementation class ConstanciaBean
 */
@Stateless
@LocalBean
public class ConstanciaBean implements ConstanciaBeanRemote {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public ConstanciaBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Constancia constancia) throws ServicesException {
   		try{
   			em.persist(constancia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear la CONSTANCIA");
   		}		
   	}

   	@Override
   	public void update(Constancia constancia) throws ServicesException {
   		try{
   			em.merge(constancia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar la CONSTANCIA");
   		}		
   	}

   	@Override
   	public void drop(Long idConstancia) throws ServicesException {
   		try{
   			Constancia constancia = em.find(Constancia.class, idConstancia);
   			em.remove(constancia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar la CONSTANCIA");
   		}
   	}
   	
   	@Override
   	public void addAccionConstancia(Long idConstancia, AccionConstancia accionConstancia) throws ServicesException {
   		try{
   			Constancia constancia = em.find(Constancia.class, idConstancia);
   			constancia.getAccionesConstancias().add(accionConstancia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar la ACCION CONSTANCIA al la CONSTANCIA");
   		}		
   	}
   	
   	@Override
   	public void removeAccionConstancia(Long idConstancia, Long idAccionConstancia) throws ServicesException {
   		try{
   			Constancia constancia = em.find(Constancia.class, idConstancia);
   			AccionConstancia accionConstancia = em.find(AccionConstancia.class, idAccionConstancia);
   			constancia.getAccionesConstancias().remove(accionConstancia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover la ACCION CONSTANCIA de la CONSTANCIA");
   		}		
   	}

   	@Override
   	public List<Constancia> findAll() {
   		TypedQuery<Constancia> query = em.createQuery("SELECT c FROM Constancia c",Constancia.class); 
   		return query.getResultList();
   	}

   	@Override
   	public List<Constancia> findAll(String filter) {
   		TypedQuery<Constancia> query = em.createQuery("SELECT c FROM Constancia c WHERE c.nombre LIKE :nombre",Constancia.class)
   				.setParameter("nombre", filter); 
   		return query.getResultList();
   	}

	@Override
	public Constancia find(Long idConstancia) throws ServicesException {
		try{
   			Constancia constancia = em.find(Constancia.class, idConstancia);
   			return constancia;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener la CONSTANCIA");
   		}
	}

}
