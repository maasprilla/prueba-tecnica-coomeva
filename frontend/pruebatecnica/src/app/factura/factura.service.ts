import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  constructor(private http: HttpClient) { }

  
  crearFactura(factura) {
    return this.http
      .post(`http://localhost:9080/facturas/create`,factura,
        { responseType: "text" }
      ).pipe(map(
        response => response, 
        error => error
      ));
  }

  obtenerTodo() {
    return this.http
      .get(`http://localhost:9080/facturas/obtenerTodo`,
        { responseType: "text" }
      ).pipe(map(
        response => response, 
        error => error
      ));
  }

  obtenerProductos() {
    return this.http
      .get(`http://localhost:9080/productos/obtenerTodo`,
        { responseType: "text" }
      ).pipe(map(
        response => response, 
        error => error
      ));
  }

  obtenerClientes() {
    return this.http
      .get(`http://localhost:9080/clientes/obtenerTodo`,
        { responseType: "text" }
      ).pipe(map(
        response => response, 
        error => error
      ));
  }
}
