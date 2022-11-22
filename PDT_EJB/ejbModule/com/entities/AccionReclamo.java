package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ACCION_RECLAMO database table.
 * 
 */
@Entity
@Table(name="ACCION_RECLAMO")
@NamedQuery(name="AccionReclamo.findAll", query="SELECT a FROM AccionReclamo a")
public class AccionReclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_ACCION_RECLAMO" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ACCION_RECLAMO")
	@Column(name="ID_ACCION_RECLAMO", unique=true, nullable=false, precision=38)
	private long idAccionReclamo;

	@Lob
	@Column(nullable=false)
	private String detalle;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA", nullable=false)
	private Date fechaHora;

	//bi-directional many-to-one association to Analista
	@ManyToOne
	@JoinColumn(name="ID_ANALISTA", nullable=false)
	private Analista analista;

	//bi-directional many-to-one association to Reclamo
	@ManyToOne
	@JoinColumn(name="ID_RECLAMO", nullable=false)
	private Reclamo reclamo;

	public AccionReclamo() {
	}

	public long getIdAccionReclamo() {
		return this.idAccionReclamo;
	}

	public void setIdAccionReclamo(long idAccionReclamo) {
		this.idAccionReclamo = idAccionReclamo;
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

	public Analista getAnalista() {
		return this.analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Reclamo getReclamo() {
		return this.reclamo;
	}

	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}

}