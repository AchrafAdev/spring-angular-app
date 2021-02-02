package com.appclientes.backend.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.appclientes.backend.models.entity.Cliente;
import com.appclientes.backend.models.service.IClienteServ;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteServ clienteServ;
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteServ.findAll();
		
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteServ.findById(id);
	}
	

	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create (@RequestBody Cliente cliente) {
		//cliente.setCreateAt(new Date());
		return clienteServ.save(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
		
		Cliente clienteActual = clienteServ.findById(id);
		
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());

		
		
		return clienteServ.save(clienteActual);
		
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteServ.delete(id);
	}
	
}
