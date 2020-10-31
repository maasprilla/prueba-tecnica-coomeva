package com.miguel.pruebatecnica.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.miguel.pruebatecnica.dominios.TestCliente;
import com.miguel.pruebatecnica.dominios.TestFactura;
import com.miguel.pruebatecnica.dominios.TestFacturaDetalle;
import com.miguel.pruebatecnica.dominios.TestProducto;
import com.miguel.pruebatecnica.dto.TestFacturaDto;
import com.miguel.pruebatecnica.services.TestClienteService;
import com.miguel.pruebatecnica.services.TestFacturaService;
import com.miguel.pruebatecnica.services.TestProductoService;

@CrossOrigin
@RestController
@RequestMapping("/facturas")
public class TestFacturaController {

	@Autowired
	private TestFacturaService testFacturaService;

    @PostMapping("/create")
    public ResponseEntity<String> createInvoice(@RequestBody TestFactura testFactura)  {
    	testFactura.setFechaVenta(new Date());
    	for (TestFacturaDetalle testFacturaDetalle : testFactura.getTestFacturaDetalleList()) {
    		testFacturaDetalle.setIdFactura(testFactura);
		}
    	TestFactura testFacturaParam = testFacturaService.save(testFactura);
    	
    	JsonObject respuesta = new JsonObject();
    	if(testFacturaParam==null) {
    		respuesta.addProperty("tipoRespuesta", 0);
    		respuesta.addProperty("mensjae", "Se ha encontrado un problema al generar la venta");
    	}else {
    		respuesta.addProperty("tipoRespuesta", 1);
    		respuesta.addProperty("mensjae", "Se ha generado la venta exitosamente");
    	}
        return ResponseEntity.ok().body(respuesta.toString());
    }

    
	@GetMapping("/obtenerTodo")
	public ResponseEntity<List<TestFacturaDto>> obtenerTodo() {
		List<TestFacturaDto> listaFactura = testFacturaService.findAll();
		
		return ResponseEntity.ok().body(listaFactura);
	}

}
