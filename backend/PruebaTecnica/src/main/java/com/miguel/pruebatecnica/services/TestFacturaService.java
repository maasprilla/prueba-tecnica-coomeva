package com.miguel.pruebatecnica.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.pruebatecnica.Dao.impl.TestClienteDaoImpl;
import com.miguel.pruebatecnica.Dao.impl.TestFacturaDaoImpl;
import com.miguel.pruebatecnica.Dao.impl.TestProductoDaoImpl;
import com.miguel.pruebatecnica.dominios.TestCliente;
import com.miguel.pruebatecnica.dominios.TestFactura;
import com.miguel.pruebatecnica.dominios.TestFacturaDetalle;
import com.miguel.pruebatecnica.dominios.TestProducto;
import com.miguel.pruebatecnica.dto.TestFacturaDto;

@Service
public class TestFacturaService {

	@Autowired
	private TestFacturaDaoImpl testFacturaDaoImpl;
	@Autowired
	private TestClienteDaoImpl testClienteDaoImpl;
	@Autowired
	private TestProductoDaoImpl testProductoDaoImpl;
	
	public TestFactura save(TestFactura testFactura) {
		TestFactura testFacturaTemp = testFacturaDaoImpl.create(testFactura);
		if(testFacturaTemp!=null) {
			for (TestFacturaDetalle detalle : testFacturaTemp.getTestFacturaDetalleList()) {
				Optional<TestProducto> product= testProductoDaoImpl.find(detalle.getIdProducto().getIdProducto());
				if(product.isPresent()==true) {
					TestProducto productoTemp = product.get();
					productoTemp.setStock(Integer.parseInt((productoTemp.getStock()-detalle.getCantidad()+"")));
					this.testProductoDaoImpl.edit(productoTemp);
				}
				
			}
		}
		return testFactura;
	}
	
	public List<TestFacturaDto> findAll() {
		List<TestFacturaDto> listaRespuesta = new ArrayList<>();
		for (TestFactura factura : testFacturaDaoImpl.findAll()) {
			TestFacturaDto facturaTemp = new TestFacturaDto();
			facturaTemp.setIdFactura(factura.getIdFactura());
			facturaTemp.setIdCliente(Long.parseLong(factura.getIdCliente().getIdCliente()+""));
			facturaTemp.setFechaVenta(factura.getFechaVenta());
			facturaTemp.setValorTotal(factura.getValorTotal());
			Optional<TestCliente> cliente= this.testClienteDaoImpl.find(facturaTemp.getIdCliente());	
			String nombreClinte = cliente.isPresent()==true?cliente.get().getNombres():"";
			facturaTemp.setNombre(nombreClinte);
			listaRespuesta.add(facturaTemp);
		}
		return listaRespuesta;
	}
	
	

}
