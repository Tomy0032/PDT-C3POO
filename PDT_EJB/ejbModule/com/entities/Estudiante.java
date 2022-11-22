package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ESTUDIANTE database table.
 * 
 */
@Entity
@Table(name="ESTUDIANTE")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_ESTUDIANTE" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ESTUDIANTE")
	@Column(name="ID_ESTUDIANTE", unique=true, nullable=false, precision=38)
	private long idEstudiante;

	//bi-directional many-to-one association to Constancia
	@OneToMany(mappedBy="estudiante")
	private List<Constancia> constancias;

	//bi-directional many-to-one association to ConvocatoriaAsistencia
	@OneToMany(mappedBy="estudiante")
	private List<ConvocatoriaAsistencia> convocatoriasAsistencias;

	//bi-directional many-to-one association to Generacion
	@ManyToOne
	@JoinColumn(name="ID_GENERACION", nullable=false)
	private Generacion generacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO", nullable=false)
	private Usuario usuario;

	//bi-directional many-to-one association to Justificacion
	@OneToMany(mappedBy="estudiante")
	private List<Justificacion> justificaciones;

	//bi-directional many-to-one association to Reclamo
	@OneToMany(mappedBy="estudiante")
	private List<Reclamo> reclamos;

	public Estudiante() {
	}

	public long getIdEstudiante() {
		return this.idEstudiante;
	}

	public List<Constancia> getConstancias() {
		return constancias;
	}

	public void setConstancias(List<Constancia> constancias) {
		this.constancias = constancias;
	}

	public List<ConvocatoriaAsistencia> getConvocatoriasAsistencias() {
		return convocatoriasAsistencias;
	}

	public void setConvocatoriasAsistencias(List<ConvocatoriaAsistencia> convocatoriasAsistencias) {
		this.convocatoriasAsistencias = convocatoriasAsistencias;
	}

	public Generacion getGeneracion() {
		return generacion;
	}

	public void setGeneracion(Generacion generacion) {
		this.generacion = generacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Justificacion> getJustificaciones() {
		return justificaciones;
	}

	public void setJustificaciones(List<Justificacion> justificaciones) {
		this.justificaciones = justificaciones;
	}

	public List<Reclamo> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

	public void setIdEstudiante(long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

}