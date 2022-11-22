package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_USUARIO" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIO")
	@Column(name="ID_USUARIO", unique=true, nullable=false, precision=38)
	private long idUsuario;

	@Column(nullable=false, length=20)
	private String apellido1;

	@Column(length=20)
	private String apellido2;

	@Column(nullable=false, length=16)
	private String contrasena;

	@Column(name="CORREO_INSTITUCIONAL", nullable=false, length=60)
	private String correoInstitucional;

	@Column(name="CORREO_PERSONAL", length=30)
	private String correoPersonal;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO", nullable=false)
	private Date fechaNacimiento;

	@Column(name="NOMBRE_USUARIO", nullable=false, length=40)
	private String nombreUsuario;

	@Column(nullable=false, length=20)
	private String nombre1;

	@Column(length=20)
	private String nombre2;

	@Column(length=10)
	private String telefono;

	//bi-directional many-to-one association to Analista
	@OneToMany(mappedBy="usuario")
	private List<Analista> analistas;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="usuario")
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to Tutor
	@OneToMany(mappedBy="usuario")
	private List<Tutor> tutores;

	//bi-directional many-to-one association to Documento
	@ManyToOne
	@JoinColumn(name="ID_DOCUMENTO", nullable=false)
	private Documento documento;

	//bi-directional many-to-one association to Genero
	@ManyToOne
	@JoinColumn(name="ID_GENERO", nullable=false)
	private Genero genero;

	//bi-directional many-to-one association to Itr
	@ManyToOne
	@JoinColumn(name="ID_ITR", nullable=false)
	private Itr itr;

	//bi-directional many-to-one association to Localidad
	@ManyToOne
	@JoinColumn(name="ID_LOCALIDAD", nullable=false)
	private Localidad localidad;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreoInstitucional() {
		return this.correoInstitucional;
	}

	public void setCorreoInstitucional(String correoInstitucional) {
		this.correoInstitucional = correoInstitucional;
	}

	public String getCorreoPersonal() {
		return this.correoPersonal;
	}

	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre1() {
		return this.nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return this.nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Analista> getAnalistas() {
		return this.analistas;
	}

	public void setAnalistas(List<Analista> analistas) {
		this.analistas = analistas;
	}

	public Analista addAnalista(Analista analista) {
		getAnalistas().add(analista);
		analista.setUsuario(this);

		return analista;
	}

	public Analista removeAnalista(Analista analista) {
		getAnalistas().remove(analista);
		analista.setUsuario(null);

		return analista;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setUsuario(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setUsuario(null);

		return estudiante;
	}

	public List<Tutor> getTutores() {
		return this.tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	public Tutor addTutor(Tutor tutor) {
		getTutores().add(tutor);
		tutor.setUsuario(this);

		return tutor;
	}

	public Tutor removeTutor(Tutor tutor) {
		getTutores().remove(tutor);
		tutor.setUsuario(null);

		return tutor;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Itr getItr() {
		return this.itr;
	}

	public void setItr(Itr itr) {
		this.itr = itr;
	}

	public Localidad getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

}