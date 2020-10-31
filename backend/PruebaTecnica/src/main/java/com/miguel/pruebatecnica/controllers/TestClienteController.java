package com.miguel.pruebatecnica.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguel.pruebatecnica.dominios.TestCliente;
import com.miguel.pruebatecnica.dominios.TestProducto;
import com.miguel.pruebatecnica.services.TestClienteService;
import com.miguel.pruebatecnica.services.TestProductoService;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class TestClienteController {

	@Autowired
	private TestClienteService testClienteService;

	@GetMapping("/obtenerTodo")
	public ResponseEntity<List<TestCliente>> obtenerTodo() {
		List<TestCliente> listaProductos = testClienteService.findAll();
		return ResponseEntity.ok().body(listaProductos);
	}

}
