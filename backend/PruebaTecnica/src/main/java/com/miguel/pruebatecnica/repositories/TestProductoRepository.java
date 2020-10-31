package com.miguel.pruebatecnica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miguel.pruebatecnica.dominios.TestProducto;

@Repository
public interface TestProductoRepository  extends JpaRepository<TestProducto, Integer>{

}
