package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOCALIDAD database table.
 * 
 */
@Entity
@Table(name="LOCALIDAD")
@NamedQuery(name="Localidad.findAll", query="SELECT l FROM Localidad l")
public class Localidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_LOCALIDAD" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_LOCALIDAD")
	@Column(name="ID_LOCALIDAD", unique=true, nullable=false, precision=38)
	private long idLocalidad;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to Itr
	@OneToMany(mappedBy="localidad")
	private List<Itr> itrs;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="ID_DEPARTAMENTO", nullable=false)
	private Departamento departamento;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="localidad")
	private List<Usuario> usuarios;

	public Localidad() {
	}

	public long getIdLocalidad() {
		return this.idLocalidad;
	}

	public void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Itr> getItrs() {
		return this.itrs;
	}

	public void setItrs(List<Itr> itrs) {
		this.itrs = itrs;
	}

	public Itr addItr(Itr itr) {
		getItrs().add(itr);
		itr.setLocalidad(this);

		return itr;
	}

	public Itr removeItr(Itr itr) {
		getItrs().remove(itr);
		itr.setLocalidad(null);

		return itr;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setLocalidad(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setLocalidad(null);

		return usuario;
	}

}