package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.AccionConstancia;
import com.entities.AccionJustificacion;
import com.entities.AccionReclamo;
import com.entities.Analista;
import com.exception.ServicesException;

/**
 * Session Bean implementation class AnalistaBean
 */
@Stateless
@LocalBean
public class AnalistaBean implements AnalistaBeanRemote {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public AnalistaBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void create(Analista analista) throws ServicesException {
		try{
   			em.persist(analista);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el ANALISTA");
   		}			
	}

	@Override
	public void update(Analista analista) throws ServicesException {
		try{
   			em.merge(analista);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el ANALISTA");
   		}	
	}

	@Override
	public void drop(Long idAnalista) throws ServicesException {
		try{
			Analista analista = em.find(Analista.class, idAnalista);
   			em.remove(analista);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el ANALISTA");
   		}
	}

	@Override
	public void addAccionConstancia(Long idAnalista, AccionConstancia accionConstancia) throws ServicesException {
		try{
			Analista analista = em.find(Analista.class, idAnalista);
			analista.getAccionesConstancias().add(accionConstancia);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar la ACCION CONSTANCIA al ANALISTA");
		}
	}

	@Override
	public void removeAccionConstancia(Long idAnalista, Long idAccionConstancia) throws ServicesException {
		try{
			Analista analista = em.find(Analista.class, idAnalista);
			AccionConstancia accionConstancia = em.find(AccionConstancia.class, idAccionConstancia);
			analista.getAccionesConstancias().remove(accionConstancia);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover la ACCION CONSTANCIA del ANALISTA");
		}		
	}

	@Override
	public void addAccionJustificacion(Long idAnalista, AccionJustificacion accionJustificacion) throws ServicesException {
		try{
			Analista analista = em.find(Analista.class, idAnalista);
			analista.getAccionesJustificaciones().add(accionJustificacion);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar la ACCION JUSTIFICACION al ANALISTA");
		}		
	}

	@Override
	public void removeAccionJustificacion(Long idAnalista, Long idAccionJustificacion) throws ServicesException {
		try{
			Analista analista = em.find(Analista.class, idAnalista);
			AccionJustificacion accionJustificacion = em.find(AccionJustificacion.class, idAccionJustificacion);
			analista.getAccionesJustificaciones().remove(accionJustificacion);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover la ACCION JUSTIFICACION del ANALISTA");
		}		
	}

	@Override
	public void addAccionReclamo(Long idAnalista, AccionReclamo accionReclamo) throws ServicesException {
		try{
			Analista analista = em.find(Analista.class, idAnalista);
			analista.getAccionesReclamos().add(accionReclamo);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar la ACCION Generacion al ANALISTA");
		}			
	}

	@Override
	public void removeAccionReclamo(Long idAnalista, Long idAccionReclamo) throws ServicesException {
		try{
			Analista analista = em.find(Analista.class, idAnalista);
			AccionReclamo accionReclamo = em.find(AccionReclamo.class, idAccionReclamo);
			analista.getAccionesReclamos().remove(accionReclamo);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover la ACCION RECLAMO del ANALISTA");
		}
	}

	@Override
	public List<Analista> findAll() {
		TypedQuery<Analista> query = em.createQuery("SELECT a FROM Analista a",Analista.class); 
   		return query.getResultList();
	}

	@Override
	public List<Analista> findAll(String filter) {
		TypedQuery<Analista> query = em.createQuery("SELECT a FROM Analista a WHERE a.nombre LIKE :nombre",Analista.class)
   				.setParameter("nombre", filter); 
   		return query.getResultList();
	}

	@Override
	public Analista find(Long idAnalista) throws ServicesException {
		try{
			Analista analista = em.find(Analista.class, idAnalista);
   			return analista;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el ANALISTA");
   		}
	}

}
