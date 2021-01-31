package com.appclientes.backend.models.service;

import java.util.List;

import com.appclientes.backend.models.entity.Cliente;

public interface IClienteServ {

	public List<Cliente> findAll();
}
