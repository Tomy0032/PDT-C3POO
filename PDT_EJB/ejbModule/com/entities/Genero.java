package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GENERO database table.
 * 
 */
@Entity
@Table(name="GENERO")
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_GENERO" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GENERO")
	@Column(name="ID_GENERO", unique=true, nullable=false, precision=38)
	private long idGenero;

	@Column(nullable=false, length=16)
	private String nombre;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="genero")
	private List<Usuario> usuarios;

	public Genero() {
	}

	public long getIdGenero() {
		return this.idGenero;
	}

	public void setIdGenero(long idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setGenero(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setGenero(null);

		return usuario;
	}

}