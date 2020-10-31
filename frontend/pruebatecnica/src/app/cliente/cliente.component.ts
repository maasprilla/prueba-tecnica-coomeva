import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { ClienteService } from './cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent implements OnInit {

  displayedColumns: string[] = ['nombre', 'apellidos', 'dni','telefono','direccion','email'];
  dataSource = new MatTableDataSource<any>();
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;


  constructor(
    private _clienteService: ClienteService,
  ) { }

  ngOnInit() {
    this._clienteService.obtenerTodo()
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
