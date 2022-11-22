package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TUTOR database table.
 * 
 */
@Entity
@Table(name="TUTOR")
@NamedQuery(name="Tutor.findAll", query="SELECT t FROM Tutor t")
public class Tutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_TUTOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TUTOR")
	@Column(name="ID_TUTOR", unique=true, nullable=false, precision=38)
	private long idTutor;

	//bi-directional many-to-one association to Responsabilidad
	@OneToMany(mappedBy="tutor")
	private List<Responsabilidad> responsabilidades;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="ID_AREA", nullable=false)
	private Area area;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="ID_TIPO", nullable=false)
	private Tipo tipo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO", nullable=false)
	private Usuario usuario;

	public Tutor() {
	}

	public long getIdTutor() {
		return this.idTutor;
	}

	public void setIdTutor(long idTutor) {
		this.idTutor = idTutor;
	}

	public List<Responsabilidad> getResponsabilidades() {
		return this.responsabilidades;
	}

	public void setResponsabilidades(List<Responsabilidad> responsabilidades) {
		this.responsabilidades = responsabilidades;
	}

	public Responsabilidad addResponsabilidad(Responsabilidad responsabilidad) {
		getResponsabilidades().add(responsabilidad);
		responsabilidad.setTutor(this);

		return responsabilidad;
	}

	public Responsabilidad removeResponsabilidad(Responsabilidad responsabilidad) {
		getResponsabilidades().remove(responsabilidad);
		responsabilidad.setTutor(null);

		return responsabilidad;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}