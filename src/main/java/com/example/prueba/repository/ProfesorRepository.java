package com.example.prueba.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.prueba.modelo.Profesor;

public interface ProfesorRepository  extends CrudRepository <Profesor, Integer>{
	public List<Profesor> findByEstado(Boolean estado);
}
