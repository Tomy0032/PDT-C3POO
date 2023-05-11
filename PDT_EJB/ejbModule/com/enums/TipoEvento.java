package com.enums;

public enum TipoEvento {
	
	JORNADA_PRESENCIAL("JORNADA PRESCENCIAL"),
	PRUEBA_FINAL("PRUEBA FINAL"),
	EXAMEN("EXAMEN"),
	DEFENSA_DE_PROYECTO("DEFENSA DE PROYECTO");
	
	private String nombre;
	
	private TipoEvento(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
