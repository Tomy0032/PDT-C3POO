package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the RECLAMO database table.
 * 
 */
@Entity
@Table(name="RECLAMO")
@NamedQuery(name="Reclamo.findAll", query="SELECT r FROM Reclamo r")
public class Reclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_RECLAMO" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_RECLAMO")
	@Column(name="ID_RECLAMO", unique=true, nullable=false, precision=38)
	private long idReclamo;

	@Lob
	@Column(nullable=false)
	private String detalle;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA", nullable=false)
	private Date fechaHora;

	//bi-directional many-to-one association to AccionReclamo
	@OneToMany(mappedBy="reclamo")
	private List<AccionReclamo> accionesReclamos;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="ID_ESTUDIANTE", nullable=false)
	private Estudiante estudiante;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO", nullable=false)
	private Evento evento;

	public Reclamo() {
	}

	public long getIdReclamo() {
		return this.idReclamo;
	}

	public void setIdReclamo(long idReclamo) {
		this.idReclamo = idReclamo;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public List<AccionReclamo> getAccionesReclamos() {
		return this.accionesReclamos;
	}

	public void setAccionesReclamos(List<AccionReclamo> accionesReclamos) {
		this.accionesReclamos = accionesReclamos;
	}

	public AccionReclamo addAccionReclamo(AccionReclamo accionReclamo) {
		getAccionesReclamos().add(accionReclamo);
		accionReclamo.setReclamo(this);

		return accionReclamo;
	}

	public AccionReclamo removeAccionReclamo(AccionReclamo accionReclamo) {
		getAccionesReclamos().remove(accionReclamo);
		accionReclamo.setReclamo(null);

		return accionReclamo;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}