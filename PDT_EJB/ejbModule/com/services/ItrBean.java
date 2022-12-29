package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Itr;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class ItrBean
 */
@Stateless
@LocalBean
public class ItrBean implements ItrBeanRemote {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public ItrBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Itr itr) throws ServicesException {
   		try{
   			em.persist(itr);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el ITR");
   		}		
   	}

   	@Override
   	public void update(Itr itr) throws ServicesException {
   		try{
   			em.merge(itr);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el ITR");
   		}		
   	}

   	@Override
   	public void drop(Long idItr) throws ServicesException {
   		try{
   			Itr itr = em.find(Itr.class, idItr);
   			em.remove(itr);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el ITR");
   		}
   	}
   	
   	@Override
   	public void addUsuario(Long idItr, Usuario usuario) throws ServicesException {
   		try{
   			Itr itr = em.find(Itr.class, idItr);
   			itr.getUsuarios().add(usuario);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar el USUARIO al ITR");
   		}		
   	}
   	
   	@Override
   	public void removeUsuario(Long idItr, Long idUsuario) throws ServicesException {
   		try{
   			Itr itr = em.find(Itr.class, idItr);
   			Usuario usuario = em.find(Usuario.class, idUsuario);
   			itr.getUsuarios().remove(usuario);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover el USUARIO del ITR");
   		}		
   	}
   	
   	@Override
   	public List<Itr> findAll() {
   		TypedQuery<Itr> query = em.createQuery("SELECT i FROM Itr i",Itr.class); 
   		return query.getResultList();
   	}

   	@Override
   	public List<Itr> findAll(String filter) {
   		TypedQuery<Itr> query = em.createQuery("SELECT i FROM Itr i WHERE i.nombre LIKE :nombre",Itr.class)
   				.setParameter("nombre", filter); 
   		return query.getResultList();
   	}

	@Override
	public Itr find(Long idItr) throws ServicesException {
		try{
   			Itr itr = em.find(Itr.class, idItr);
   			return itr;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el ITR");
   		}
	}

}
