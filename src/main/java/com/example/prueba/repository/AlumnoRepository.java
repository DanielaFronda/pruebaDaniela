package com.example.prueba.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.prueba.modelo.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno,Integer>{
	public List<Alumno> findByEstado(Boolean estado);
}
