package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Genero;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class Genero
 */
@Stateless
@LocalBean
public class GeneroBean implements GeneroBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public GeneroBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Genero genero) throws ServicesException {
   		try{
   			em.persist(genero);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el GENERO");
   		}		
   	}

   	@Override
   	public void update(Genero genero) throws ServicesException {
   		try{
   			em.merge(genero);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el GENERO");
   		}		
   	}

   	@Override
   	public void drop(Long idGenero) throws ServicesException {
   		try{
   			Genero genero = em.find(Genero.class, idGenero);
   			em.remove(genero);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el GENERO");
   		}
   	}
   	
   	@Override
   	public void addUsuario(Long idGenero, Usuario usuario) throws ServicesException {
   		try{
   			Genero genero = em.find(Genero.class, idGenero);
   			genero.getUsuarios().add(usuario);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar el USUARIO al GENERO");
   		}		
   	}
   	
   	@Override
   	public void removeUsuario(Long idGenero, Long idUsuario) throws ServicesException {
   		try{
   			Genero genero = em.find(Genero.class, idGenero);
   			Usuario usuario = em.find(Usuario.class, idUsuario);
   			genero.getUsuarios().remove(usuario);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover el USUARIO del GENERO");
   		}		
   	}
   	
   	@Override
   	public List<Genero> findAll() throws ServicesException {
   		try {
	   		TypedQuery<Genero> query = em.createQuery("SELECT g FROM Genero g",Genero.class); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron GENEROS");
		}
   	}

   	@Override
   	public List<Genero> findAll(String filter) throws ServicesException {
   		try {
	   		TypedQuery<Genero> query = em.createQuery("SELECT g FROM Genero g WHERE g.nombre LIKE :nombre",Genero.class)
	   				.setParameter("nombre", filter); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron GENEROS con ese NOMBRE");
		}
   	}

	@Override
	public Genero find(Long idGenero) throws ServicesException {
		try{
   			Genero genero = em.find(Genero.class, idGenero);
   			return genero;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el GENERO");
   		}
	}

}
