package com.miguel.pruebatecnica.Dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.pruebatecnica.dominios.TestCliente;
import com.miguel.pruebatecnica.dominios.TestFactura;
import com.miguel.pruebatecnica.dominios.TestFacturaDetalle;
import com.miguel.pruebatecnica.dominios.TestProducto;
import com.miguel.pruebatecnica.repositories.TestClienteRepository;
import com.miguel.pruebatecnica.repositories.TestFacturaDetalleRepository;
import com.miguel.pruebatecnica.repositories.TestFacturaRepository;
import com.miguel.pruebatecnica.repositories.TestProductoRepository;

@Service
public class TestFacturaDetalleDaoImpl {

	@Autowired
	private TestFacturaDetalleRepository testFacturaDetalleRepository;
	
    public void create(TestFacturaDetalle entity) {
        this.testFacturaDetalleRepository.save(entity);
    }

    public TestFacturaDetalle edit(TestFacturaDetalle entity) {
    	return this.testFacturaDetalleRepository.save(entity);
    }

    public void remove(TestFacturaDetalle entity) {
        this.testFacturaDetalleRepository.delete(entity);
    }

    public Optional<TestFacturaDetalle> find(Long id) {
        return this.testFacturaDetalleRepository.findById(id);
    }

    public List<TestFacturaDetalle> findAll() {
        return this.testFacturaDetalleRepository.findAll();
    }

}
