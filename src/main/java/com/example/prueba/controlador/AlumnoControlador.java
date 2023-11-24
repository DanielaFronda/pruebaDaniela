package com.example.prueba.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.prueba.modelo.Alumno;
import com.example.prueba.service.AlumnoService;
import com.example.prueba.util.ListadoAlumnos;

@Controller
public class AlumnoControlador {
	
	@Autowired
	Alumno  alu ;
	
	@Autowired
	AlumnoService  alumnoService ;
	
		
	//para cargar la pagina principal
	@GetMapping({"/index","/","/home"})
	public ModelAndView iniciari(){
			
		ModelAndView modelView=new ModelAndView("index");
		return modelView;
	}
	
	//para cargar la pagina principal
		@GetMapping({"/alumno"})
		public ModelAndView recibirAlumno(){
				
			ModelAndView modelView=new ModelAndView("alumno");
			modelView.addObject("alumno",alu);
			return modelView;
		}


	//para agregar un alumno a la vista
	@PostMapping("/mostrarAlumno")
	public ModelAndView mostrarAlumno(@ModelAttribute("alumno") Alumno alumno){
		
		//ListadoAlumnos.getListado().add(alumno);
		alumnoService.guardarAlumno(alumno);
		
		ModelAndView modelView=new ModelAndView("mostrarListado");
				
		//modelView.addObject("lista",ListadoAlumnos.getListado());
		modelView.addObject("lista",alumnoService.buscarTodosLosAlumnos());
		
		return modelView;
	}
	
	@GetMapping("/mostrarListado")
	public ModelAndView mostrarlistado(@ModelAttribute("alumno") Alumno alumno){
		
		ModelAndView modelView=new ModelAndView("mostrarListado");
				
		modelView.addObject("lista",alumnoService.buscarTodosLosAlumnos());
		
		return modelView;
	}
	//para eliminar un Alumno
		@GetMapping({"/eliminarAlumno/{dni}"})
		public String eliminarAlumno(@PathVariable Integer dni) throws Exception {
			//eliminarAlumno  alu =new Alumno();
			alumnoService.eliminarAlumno(dni);
			return "redirect:/mostrarListado";	
		}
		
		//para modificar un Alumno
			@GetMapping({"/modificarAlumno/{dni}"})
			public ModelAndView modificarAlumno(@PathVariable Integer dni)throws Exception{
				
				ModelAndView modelview = new ModelAndView("Alumno");
				modelview.addObject("alumno", alumnoService.encontrarUnAlumno(dni));
				return modelview;	
			
			}
}
