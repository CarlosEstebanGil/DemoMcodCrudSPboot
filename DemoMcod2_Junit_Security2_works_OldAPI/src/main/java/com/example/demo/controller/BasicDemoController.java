package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
/* import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity; */
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.stereotype.Controller; //**va 
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.data.dao.IPersonaRepo;
//import com.example.demo.data.model.IPersona;
import com.example.demo.data.model.Persona;

@RestController  
@RequestMapping("/personas") 	  
public class BasicDemoController {			  
	
	private static Logger LOG = LoggerFactory.getLogger(BasicDemoController.class);
	
	@Autowired						 
	private IPersonaRepo persRepo;    
	
	@GetMapping("/savePers")
	public void guardarPersona() {
		
		Persona pers = new Persona();
		pers.setIdPersona(1);
		pers.setNombre("charly san");
		
		persRepo.save(pers);
		
		LOG.info("Persona correctamente insertada por GET");
	}
	
	/*@PreAuthorize("hasAuthority('ADMIN')")*/
	@GetMapping("/listAllPers")
	public Authentication listarPersonas() { //void listarPersonas() {
		
		List<Persona> lPersonas = persRepo.findAll();
		
		for (Persona persona : lPersonas) {		
			LOG.info(persona.toString());		 
		}
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	
	@GetMapping("/listAllPersJSON")
	public List<Persona>listarPersonasJSON() {
		List<Persona> lPersonas = persRepo.findAll();
		return lPersonas;   
	}
	
	@PostMapping			
	public void insertarPersona(@RequestBody Persona per) {
		persRepo.save(per);
		LOG.info("Persona correctamente insertada por POST");  
	}														
	 		
	@PutMapping											
	public void modificar(@RequestBody Persona per) {
		persRepo.save(per);
		
		LOG.info("Persona correctamente actualizada o insertada por PUT"); 
	}

	@DeleteMapping(value ="/{id}")  
	public void eliminarPersona(@PathVariable("id") Integer id) {  
		persRepo.deleteById(id);						 			 
		LOG.info("Persona correctamente borrada por DELETE"); 
	}
	
}
