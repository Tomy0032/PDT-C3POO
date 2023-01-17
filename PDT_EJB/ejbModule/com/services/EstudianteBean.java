package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Constancia;
import com.entities.ConvocatoriaAsistencia;
import com.entities.Estudiante;
import com.entities.Generacion;
import com.entities.Justificacion;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class EstudianteBean
 */
@Stateless
@LocalBean
public class EstudianteBean implements EstudianteBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public EstudianteBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void create(Estudiante estudiante) throws ServicesException {
		try{
   			em.persist(estudiante);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el ESTUDIANTE");
   		}			
	}

	@Override
	public void update(Estudiante estudiante) throws ServicesException {
		try{
   			em.merge(estudiante);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el ESTUDIANTE");
   		}	
	}

	@Override
	public void drop(Long idEstudiante) throws ServicesException {
		try{
			Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
   			em.remove(estudiante);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el ESTUDIANTE");
   		}
	}

	@Override
	public void addConstancia(Long idEstudiante, Constancia constancia) throws ServicesException {
		try{
			Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
			estudiante.getConstancias().add(constancia);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar la CONSTANCIA al ESTUDIANTE");
		}
	}

	@Override
	public void removeConstancia(Long idEstudiante, Long idConstancia) throws ServicesException {
		try{
			Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
			Constancia constancia = em.find(Constancia.class, idConstancia);
			estudiante.getConstancias().remove(constancia);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover la CONSTANCIA del ESTUDIANTE");
		}		
	}
	
	@Override
   	public void addJustificacion(Long idEstudiante, Justificacion justificacion)
   			throws ServicesException {
   		try{
   			Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
   			estudiante.getJustificaciones().add(justificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar la JUSTIFICACION al ESTUDIANTE");
   		}		
   	}

   	@Override
   	public void removeJustificacion(Long idEstudiante, Long idJustificacion) throws ServicesException {
   		try{
   			Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
   			Justificacion justificacion = em.find(Justificacion.class, idJustificacion);
   			estudiante.getJustificaciones().remove(justificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover la JUSTIFICACION del ESTUDIANTE");
   		}		
   	}

	@Override
	public void addConvocatoriaAsistencia(Long idEstudiante, ConvocatoriaAsistencia convocatoriaAsistencia) throws ServicesException {
		try{
			Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
			estudiante.getConvocatoriasAsistencias().add(convocatoriaAsistencia);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar la CONVOCATORIA ASISTENCIA al ESTUDIANTE");
		}			
	}

	@Override
	public void removeConvocatoriaAsistencia(Long idEstudiante, Long idConvocatoriaAsistencia) throws ServicesException {
		try{
			Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
			ConvocatoriaAsistencia convocatoriaAsistencia = em.find(ConvocatoriaAsistencia.class, idConvocatoriaAsistencia);
			estudiante.getConvocatoriasAsistencias().remove(convocatoriaAsistencia);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover la CONVOCATORIA ASISTENCIA del ESTUDIANTE");
		}
	}

	@Override
	public List<Estudiante> findAll() throws ServicesException {
		try {
			TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e",Estudiante.class); 
	   		return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron ESTUDIANTES");
		}
	}

	@Override
	public List<Estudiante> findAllForGeneracion(Generacion generacion) throws ServicesException {
		try{
			TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE e.generacion = :generacion",Estudiante.class)
	   				.setParameter("geenracion", generacion); 
	   		return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron ESTUDIANTES en esa GENERACION");
		}
	}

	@Override
	public Estudiante find(Long idEstudiante) throws ServicesException {
		try{
			Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
   			return estudiante;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el ESTUDIANTE");
   		}
	} 
	
	@Override
	public Estudiante findForUser(Usuario usuario) throws ServicesException {
		try {
			TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE e.usuario = :usuario",Estudiante.class)
	   				.setParameter("usuario", usuario); 
	   		return query.getResultList().get(0);
		}catch(Exception e) {
			throw new ServicesException("El USUARIO no es ESTUDIANTE");
		}
	}

}
