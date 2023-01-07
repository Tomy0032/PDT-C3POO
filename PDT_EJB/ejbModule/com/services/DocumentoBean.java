package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Documento;
import com.exception.ServicesException;

/**
 * Session Bean implementation class DocumentoBean
 */
@Stateless
@LocalBean
public class DocumentoBean implements DocumentoBeanRemote {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public DocumentoBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Documento documento) throws ServicesException {
   		try{
   			em.persist(documento);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el DOCUMENTO");
   		}		
   	}

   	@Override
   	public void update(Documento documento) throws ServicesException {
   		try{
   			em.merge(documento);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el DOCUMENTO");
   		}		
   	}

   	@Override
   	public void drop(Long idDocumento) throws ServicesException {
   		try{
   			Documento documento = em.find(Documento.class, idDocumento);
   			em.remove(documento);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el DOCUMENTO");
   		}
   	}
   	
   	@Override
   	public List<Documento> findAll() {
   		TypedQuery<Documento> query = em.createQuery("SELECT d FROM Documento d",Documento.class); 
   		return query.getResultList();
   	}

   	@Override
   	public List<Documento> findAll(String filter) {
   		TypedQuery<Documento> query = em.createQuery("SELECT d FROM Documento d WHERE d.caracteres LIKE :caracteres",Documento.class)
   				.setParameter("caracteres", filter); 
   		return query.getResultList();
   	}

	@Override
	public Documento find(Long idDocumento) throws ServicesException {
		try{
   			Documento documento = em.find(Documento.class, idDocumento);
   			return documento;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el DOCUMENTO");
   		}
	}

}
