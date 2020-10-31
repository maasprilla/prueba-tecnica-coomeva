package com.miguel.pruebatecnica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.miguel.pruebatecnica.dominios.TestFactura;

@Repository
public interface TestFacturaRepository  extends JpaRepository<TestFactura, Long>{

}
