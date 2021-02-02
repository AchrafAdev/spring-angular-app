package com.appclientes.backend.models.service;

import java.util.List;

import com.appclientes.backend.models.entity.Cliente;

public interface IClienteServ {

	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
}
