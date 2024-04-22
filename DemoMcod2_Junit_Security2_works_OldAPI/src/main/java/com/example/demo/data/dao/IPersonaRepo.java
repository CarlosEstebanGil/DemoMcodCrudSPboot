package com.example.demo.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.example.demo.data.model.IPersona;
import com.example.demo.data.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{ 	 
}
