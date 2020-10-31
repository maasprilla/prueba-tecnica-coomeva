import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatDialog } from '@angular/material';
import { DetalleVentaComponent } from '../modales/detalle-venta/detalle-venta.component';
import { FacturaService } from './factura.service';

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.scss']
})
export class FacturaComponent implements OnInit {

  displayedColumns: string[] = ['id', 'cliente', 'fecha', 'total'];
  dataSource = new MatTableDataSource<any>();
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;


  constructor(
    private _facturaService: FacturaService,
    private dialog: MatDialog
  ) { }

  ngOnInit() {
    this.obtenerFacturas();
  }

  obtenerFacturas() {
    this._facturaService.obtenerTodo()
      .subscribe(
        (respuestaObtenerTodo: any) => {
          let respuesta = JSON.parse(respuestaObtenerTodo);
          console.log(respuesta);
          this.dataSource = new MatTableDataSource<any>(respuesta);
        }, err => {
          console.log(err);
        }
      )
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  openDialog() {
    let dialogoDetalle = this.dialog.open(DetalleVentaComponent,
      {
        width: '810px',
      });

    dialogoDetalle.afterClosed().subscribe(result => {
      console.log('result', result)
      this.obtenerFacturas();

    });
  }

}
