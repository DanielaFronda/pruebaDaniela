package com.example.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.modelo.Profesor;
import com.example.prueba.repository.ProfesorRepository;

@Service
public class ProfesorService {
	@Autowired
	ProfesorRepository docenteRepository;
	
	public void guardarDocente(Profesor docente) {
		docente.setEstado(true);
		docenteRepository.save(docente);
		
	}
	
	public void eliminarDocente(Integer dni) throws Exception {
		Profesor auxiliar = new Profesor();
		auxiliar = encontrarUnDocente(dni);
		auxiliar.setEstado(false);
		docenteRepository.save(auxiliar);
		
	}
	
	public List<Profesor> buscarTodosDocentes(){
		return (List<Profesor>) docenteRepository.findByEstado(true);
	}
	
	public void modificarDocente (Profesor docente) {
		
	}
	
	public Profesor encontrarUnDocente(Integer dni) throws Exception {
		return docenteRepository.findById(dni).orElseThrow(()-> new Exception("Docente no encontrado"));
	}

}
