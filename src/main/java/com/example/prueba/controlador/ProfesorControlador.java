package com.example.prueba.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.prueba.modelo.Profesor;
import com.example.prueba.service.ProfesorService;

@Controller
public class ProfesorControlador {
	@Autowired
	Profesor docente;
	
	@Autowired
	ProfesorService docenteService;
	
	@GetMapping({"/docente"})
	public ModelAndView cargarDocente() {
		
		ModelAndView modelView = new ModelAndView ("profesor");
		modelView.addObject("docente", docente);
		return modelView;	
	}
	
	@PostMapping("/cargarDocente")
    public ModelAndView cargarDocente(@ModelAttribute Profesor docente) {
		
		docenteService.guardarDocente(docente);
        ModelAndView modelView = new ModelAndView ("listadoProfesores");
        modelView.addObject("listado2", docenteService.buscarTodosDocentes());
		return modelView;	
	}
	
	@GetMapping("/eliminarDocente/{dni}")
	public String eliminarDocente(@PathVariable Integer dni) throws Exception {
		docenteService.eliminarDocente(dni);
		return "redirect:/mostrarListado2";	
	}
	
	@GetMapping("/mostrarListado2")
	public ModelAndView mostrarDocentes(){
		ModelAndView listado2 = new ModelAndView("listadoProfesores");
		listado2.addObject("listado2", docenteService.buscarTodosDocentes());
		return listado2;	
	}
	
	@GetMapping("/modificarDocente/{dni}")
	public ModelAndView modificarDocente(@PathVariable Integer dni) throws Exception {
		ModelAndView modificaDocente = new ModelAndView("profesor");
		modificaDocente.addObject("docente", docenteService.encontrarUnDocente(dni));
		return modificaDocente;	
	}
	
	@PostMapping("/modificarDocente")
    public ModelAndView modificarUnDocente(@ModelAttribute("docente") Profesor docente) {
		
        docenteService.guardarDocente(docente);
        ModelAndView modelView = new ModelAndView ("listadoProfesores");
        modelView.addObject("listado2", docenteService.buscarTodosDocentes());
		return modelView;	
	}

}
