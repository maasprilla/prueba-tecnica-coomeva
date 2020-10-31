package com.miguel.pruebatecnica.Dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.pruebatecnica.dominios.TestCliente;
import com.miguel.pruebatecnica.dominios.TestFactura;
import com.miguel.pruebatecnica.dominios.TestProducto;
import com.miguel.pruebatecnica.repositories.TestClienteRepository;
import com.miguel.pruebatecnica.repositories.TestFacturaRepository;
import com.miguel.pruebatecnica.repositories.TestProductoRepository;

@Service
public class TestFacturaDaoImpl {

	@Autowired
	private TestFacturaRepository testFacturaRepository;
	
    public TestFactura create(TestFactura entity) {
        return this.testFacturaRepository.save(entity);
    }

    public TestFactura edit(TestFactura entity) {
    	return this.testFacturaRepository.save(entity);
    }

    public void remove(TestFactura entity) {
        this.testFacturaRepository.delete(entity);
    }

    public Optional<TestFactura> find(Long id) {
        return this.testFacturaRepository.findById(id);
    }

    public List<TestFactura> findAll() {
        return this.testFacturaRepository.findAll();
    }

}
