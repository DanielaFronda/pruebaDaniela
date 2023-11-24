package com.example.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.modelo.Alumno;
import com.example.prueba.repository.AlumnoRepository;

@Service
public class AlumnoService {
	@Autowired
	AlumnoRepository alumnoRepository;
	
	public void guardarAlumno(Alumno alu) {
		alu.setEstado(true);
		alumnoRepository.save(alu);
	}
	
	public void eliminarAlumno(Integer dni) throws Exception{
		Alumno auxiliar=new Alumno();
		auxiliar=encontrarUnAlumno(dni);
		auxiliar.setEstado(false);
		alumnoRepository.save(auxiliar);
	}
	public List<Alumno> buscarTodosLosAlumnos(){
		return (List<Alumno>) alumnoRepository.findByEstado(true);
	}
	public void modificarAlumno(Alumno alu) {
		 
	}
	
	public Alumno encontrarUnAlumno(Integer dni)throws Exception{
		return alumnoRepository.findById(dni).orElseThrow(()->new Exception("Alumno no encontrado"));
	}
	
}
