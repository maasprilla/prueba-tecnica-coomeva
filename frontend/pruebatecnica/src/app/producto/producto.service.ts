import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(private http: HttpClient) { }

  obtenerTodo() {
    return this.http
      .get(`http://localhost:9080/productos/obtenerTodo`,
        { responseType: "text" }
      ).pipe(map(
        response => response, 
        error => error
      ));
  }

}
