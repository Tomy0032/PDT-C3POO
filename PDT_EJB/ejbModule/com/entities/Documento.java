package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DOCUMENTO database table.
 * 
 */
@Entity
@Table(name="DOCUMENTO")
@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_DOCUMENTO" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DOCUMENTO")
	@Column(name="ID_DOCUMENTO", unique=true, nullable=false, precision=38)
	private long idDocumento;

	@Column(nullable=false, length=16)
	private String caracteres;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="ID_PAIS", nullable=false)
	private Pais pais;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="documento")
	private List<Usuario> usuarios;

	public Documento() {
	}

	public long getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(long idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getCaracteres() {
		return this.caracteres;
	}

	public void setCaracteres(String caracteres) {
		this.caracteres = caracteres;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setDocumento(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setDocumento(null);

		return usuario;
	}

}