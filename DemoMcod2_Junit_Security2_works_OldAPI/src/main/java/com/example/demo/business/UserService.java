package com.example.demo.business;

import java.util.ArrayList;
import java.util.List;

/* x ahora la comento esto era de secutirty api del tut mit... */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.data.dao.IUsuarioRepo;
import com.example.demo.data.model.Usuario;

@Service 
public class UserService implements UserDetailsService {

	@Autowired
	private IUsuarioRepo usuRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		
		Usuario usu = usuRepo.findByNombre(username); 
														
		List<GrantedAuthority> roles = new ArrayList<>();
		
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDet = new User (usu.getNombre(), usu.getClave(), roles);
		
		return userDet;
	}
} 

