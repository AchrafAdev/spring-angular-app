package com.appclientes.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.appclientes.backend.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
