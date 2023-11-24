package com.example.prueba.util;

import java.util.ArrayList;
import java.util.List;

import com.example.prueba.modelo.Alumno;

public class ListadoAlumnos {
	private static List<Alumno> listado=new ArrayList<>();
	
	public ListadoAlumnos() {
		
	}

	public static List<Alumno> getListado() {
		return listado;
	}

	public static void setListado(List<Alumno> listado) {
		ListadoAlumnos.listado = listado;
	}
	
}
