package com.miguel.pruebatecnica.Dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.pruebatecnica.dominios.TestCliente;
import com.miguel.pruebatecnica.dominios.TestProducto;
import com.miguel.pruebatecnica.repositories.TestClienteRepository;
import com.miguel.pruebatecnica.repositories.TestProductoRepository;

@Service
public class TestProductoDaoImpl {

	@Autowired
	private TestProductoRepository testProductoRepository;
	
    public void create(TestProducto entity) {
        this.testProductoRepository.save(entity);
    }

    public TestProducto edit(TestProducto entity) {
    	return this.testProductoRepository.save(entity);
    }

    public void remove(TestProducto entity) {
        this.testProductoRepository.delete(entity);
    }

    public Optional<TestProducto> find(Integer id) {
        return this.testProductoRepository.findById(id);
    }

    public List<TestProducto> findAll() {
        return this.testProductoRepository.findAll();
    }

}
