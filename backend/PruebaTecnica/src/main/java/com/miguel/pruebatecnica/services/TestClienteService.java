package com.miguel.pruebatecnica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.pruebatecnica.Dao.impl.TestClienteDaoImpl;
import com.miguel.pruebatecnica.Dao.impl.TestProductoDaoImpl;
import com.miguel.pruebatecnica.dominios.TestCliente;
import com.miguel.pruebatecnica.dominios.TestProducto;

@Service
public class TestClienteService {

	@Autowired
	private TestClienteDaoImpl testClienteDaoImpl;
	
	public List<TestCliente> findAll() {
		return testClienteDaoImpl.findAll();
	}

}
