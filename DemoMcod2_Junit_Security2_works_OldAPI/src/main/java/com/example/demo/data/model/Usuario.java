package com.example.demo.data.model;

import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;


@Entity
public class Usuario {

	//constructores:
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombre, String clave, List<GrantedAuthority> roles) { /*Set<Role> roles) { */
		this.nombre = nombre;
		this.clave = clave;
	/*	this.roles = roles; */
	}

	//Atributos:
	
	@Id
	private int id;
	
	private String nombre;	
	private String clave;
	
	/* @ManyToMany 
	private List<GrantedAuthority> roles;  // Set<Role> roles ; 
	*/
	private boolean enabled;
	    
	// Getters & Setters:
	    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	//Metodos:
	/*
	public List<GrantedAuthority> getRoles() {
		return roles;
	}

	public void setRoles(List<GrantedAuthority> roles) {
		this.roles = roles;
	}*/

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", clave=" + clave +"]"; // + ", roles=" + roles + ", enabled="+ enabled + "]";
	}
}
