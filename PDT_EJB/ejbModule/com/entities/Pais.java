package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PAIS database table.
 * 
 */
@Entity
@Table(name="PAIS")
@NamedQuery(name="Pai.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_PAIS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PAIS")
	@Column(name="ID_PAIS", unique=true, nullable=false, precision=38)
	private long idPais;

	@Column(nullable=false, unique=true, length=16)
	private String nombre;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="pais")
	private List<Documento> documentos;

	public Pais() {
	}

	public long getIdPais() {
		return this.idPais;
	}

	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Documento addDocumento(Documento documento) {
		getDocumentos().add(documento);
		documento.setPais(this);

		return documento;
	}

	public Documento removeDocumento(Documento documento) {
		getDocumentos().remove(documento);
		documento.setPais(null);

		return documento;
	}

}