package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CONVOCATORIA_ASISTENCIA database table.
 * 
 */
@Entity
@Table(name="CONVOCATORIA_ASISTENCIA")
@NamedQuery(name="ConvocatoriaAsistencia.findAll", query="SELECT c FROM ConvocatoriaAsistencia c")
public class ConvocatoriaAsistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_CONVOCATORIA_ASISTENCIA" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONVOCATORIA_ASISTENCIA")
	@Column(name="ID_CONVOCATORIA_ASISTENCIA", unique=true, nullable=false, precision=38)
	private long idConvocatoriaAsistencia;

	@Column(nullable=false, length=2)
	private String asistencia;

	@Column(nullable=false, precision=38)
	private BigDecimal calificacion;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="ID_USUARIO", nullable=false)
	private Usuario estudiante;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO", nullable=false)
	private Evento evento;

	public ConvocatoriaAsistencia() {
	}

	public long getIdConvocatoriaAsistencia() {
		return this.idConvocatoriaAsistencia;
	}

	public void setIdConvocatoriaAsistencia(long idConvocatoriaAsistencia) {
		this.idConvocatoriaAsistencia = idConvocatoriaAsistencia;
	}

	public String getAsistencia() {
		return this.asistencia;
	}

	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}

	public BigDecimal getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}

	public Usuario getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Usuario estudiante) {
		this.estudiante = estudiante;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}