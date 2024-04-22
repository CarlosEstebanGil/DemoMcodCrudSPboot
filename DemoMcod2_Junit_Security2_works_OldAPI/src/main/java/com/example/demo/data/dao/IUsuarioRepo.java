package com.example.demo.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.example.demo.data.model.Persona;
import com.example.demo.data.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{ 	 

	Usuario findByNombre(String nombre); 
		
}
