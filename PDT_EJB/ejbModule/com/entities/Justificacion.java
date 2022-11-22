package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Justificacion database table.
 * 
 */
@Entity
@Table(name="Justificacion")
@NamedQuery(name="Justificacion.findAll", query="SELECT j FROM Justificacion j")
public class Justificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_JUSTIFICACION" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_JUSTIFICACION")
	@Column(name="ID_JUSTIFICACION", unique=true, nullable=false, precision=38)
	private long idJustificacion;

	@Lob
	@Column(nullable=false)
	private String detalle;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA", nullable=false)
	private Date fechaHora;

	//bi-directional many-to-one association to AccionJustificacion
	@OneToMany(mappedBy="justificacion")
	private List<AccionJustificacion> accionesJustificaciones;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="ID_ESTUDIANTE", nullable=false)
	private Estudiante estudiante;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO", nullable=false)
	private Evento evento;

	public Justificacion() {
	}

	public long getIdJustificacion() {
		return idJustificacion;
	}

	public void setIdJustificacion(long idJustificacion) {
		this.idJustificacion = idJustificacion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public List<AccionJustificacion> getAccionesJustificaciones() {
		return accionesJustificaciones;
	}

	public void setAccionesJustificaciones(List<AccionJustificacion> accionesJustificaciones) {
		this.accionesJustificaciones = accionesJustificaciones;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}