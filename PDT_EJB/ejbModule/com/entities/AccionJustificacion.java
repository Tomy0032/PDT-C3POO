package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ACCION_GENERACION database table.
 * 
 */
@Entity
@Table(name="ACCION_GENERACION")
@NamedQuery(name="AccionJustificacion.findAll", query="SELECT a FROM AccionJustificacion a")
public class AccionJustificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_ACCION_JUSTIFICACION" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ACCION_JUSTIFICACION")
	@Column(name="ID_ACCION_JUSTIFICACION", unique=true, nullable=false, precision=38)
	private long idAccionJustificacion;

	@Lob
	@Column(nullable=false)
	private String detalle;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA", nullable=false)
	private Date fechaHora;

	//bi-directional many-to-one association to Analista
	@ManyToOne
	@JoinColumn(name="ID_USUARIO", nullable=false)
	private Usuario analista;

	//bi-directional many-to-one association to Justificacion
	@ManyToOne
	@JoinColumn(name="ID_JUSTIFICACION", nullable=false)
	private Justificacion justificacion;

	public AccionJustificacion() {
	}

	public long getIdAccionJustificacion() {
		return idAccionJustificacion;
	}

	public void setIdAccionJustificacion(long idAccionJustificacion) {
		this.idAccionJustificacion = idAccionJustificacion;
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

	public Usuario getAnalista() {
		return analista;
	}

	public void setAnalista(Usuario analista) {
		this.analista = analista;
	}

	public Justificacion getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(Justificacion justificacion) {
		this.justificacion = justificacion;
	}
	
}