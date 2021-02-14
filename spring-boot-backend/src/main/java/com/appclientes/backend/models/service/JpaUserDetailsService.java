package com.appclientes.backend.models.service;

import com.appclientes.backend.models.entity.Cliente;
import com.appclientes.backend.models.entity.Rol;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.appclientes.backend.models.dao.IUserAPIDao;
import com.appclientes.backend.models.entity.UserAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	public IUserAPIDao userAPIDao;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAPI userAPI = userAPIDao.findByUsername(username);
		
		if(userAPI == null ){
			throw new UsernameNotFoundException("Username :"+ username +" no existe en el sistema!");
		}

		List<GrantedAuthority> authorities = userAPI.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getAuthority())).collect(Collectors.toList());


		if(authorities.isEmpty()){
			throw new UsernameNotFoundException("Username: "+username+" no tiene roles asignados");
		}


		return new User(userAPI.getUsername(), userAPI.getPassword(), userAPI.getEnabled(), true, true, true, authorities);
	}

	public void save(UserAPI userAPI) {

		userAPIDao.save(userAPI);
	}

}
