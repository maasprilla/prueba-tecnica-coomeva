package com.miguel.pruebatecnica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.pruebatecnica.Dao.impl.TestProductoDaoImpl;
import com.miguel.pruebatecnica.dominios.TestProducto;

@Service
public class TestProductoService {

	@Autowired
	private TestProductoDaoImpl testProductoDaoImpl;
	
	public List<TestProducto> findAll() {
		return testProductoDaoImpl.findAll();
	}

}
