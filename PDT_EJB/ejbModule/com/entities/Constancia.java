package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CONSTANCIA database table.
 * 
 */
@Entity
@Table(name="CONSTANCIA")
@NamedQuery(name="Constancia.findAll", query="SELECT c FROM Constancia c")
public class Constancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_CONSTANCIA" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONSTANCIA")
	@Column(name="ID_CONSTANCIA", unique=true, nullable=false, precision=38)
	private long idConstancia;

	@Lob
	@Column(nullable=false)
	private String detalle;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA", nullable=false)
	private Date fechaHora;

	//bi-directional many-to-one association to AccionConstancia
	@OneToMany(mappedBy="constancia")
	private List<AccionConstancia> accionesConstancias;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="ID_USUARIO", nullable=false)
	private Usuario estudiante;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO", nullable=false)
	private Evento evento;

	public Constancia() {
	}

	public long getIdConstancia() {
		return this.idConstancia;
	}

	public void setIdConstancia(long idConstancia) {
		this.idConstancia = idConstancia;
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

	public List<AccionConstancia> getAccionesConstancias() {
		return this.accionesConstancias;
	}

	public void setAccionesConstancias(List<AccionConstancia> accionesConstancias) {
		this.accionesConstancias = accionesConstancias;
	}

	public AccionConstancia addAccionConstancia(AccionConstancia accionConstancia) {
		getAccionesConstancias().add(accionConstancia);
		accionConstancia.setConstancia(this);

		return accionConstancia;
	}

	public AccionConstancia removeAccionConstancia(AccionConstancia accionConstancia) {
		getAccionesConstancias().remove(accionConstancia);
		accionConstancia.setConstancia(null);

		return accionConstancia;
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