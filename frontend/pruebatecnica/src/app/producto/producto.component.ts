import { ViewChild } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MatPaginator } from '@angular/material';
import { MatTableDataSource } from '@angular/material/table';
import { ProductoService } from './producto.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.scss']
})
export class ProductoComponent implements OnInit {

  displayedColumns: string[] = ['nombre', 'valor', 'stock'];
  dataSource = new MatTableDataSource<any>();
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;



  constructor(
    private _productoService: ProductoService,
  ) { }

  ngOnInit() {
    this._productoService.obtenerTodo()
    .subscribe(
      (respuestaObtenerTodo:any)=>{
        let respuesta = JSON.parse(respuestaObtenerTodo);
        console.log(respuesta);
        this.dataSource = new MatTableDataSource<any>(respuesta);
      },err=>{
        console.log(err);
      }
    )

  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }



}
