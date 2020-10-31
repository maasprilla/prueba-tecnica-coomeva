package com.miguel.pruebatecnica.Dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.pruebatecnica.dominios.TestCliente;
import com.miguel.pruebatecnica.repositories.TestClienteRepository;

@Service
public class TestClienteDaoImpl {

	@Autowired
	private TestClienteRepository testClienteRepository;
	
    public void create(TestCliente entity) {
        this.testClienteRepository.save(entity);
    }

    public TestCliente edit(TestCliente entity) {
    	return this.testClienteRepository.save(entity);
    }

    public void remove(TestCliente entity) {
        this.testClienteRepository.delete(entity);
    }

    public Optional<TestCliente> find(Long id) {
        return this.testClienteRepository.findById(id);
    }

    public List<TestCliente> findAll() {
        return this.testClienteRepository.findAll();
    }

}
