import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource, MatPaginator, MatDialogRef } from '@angular/material';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { FacturaService } from 'src/app/factura/factura.service';

@Component({
  selector: 'app-detalle-venta',
  templateUrl: './detalle-venta.component.html',
  styleUrls: ['./detalle-venta.component.scss']
})
export class DetalleVentaComponent implements OnInit {

  formVenta: FormGroup;
  options: string[] = ['One', 'Two', 'Three'];
  filteredOptions: Observable<string[]>;
  filteredOptionsCliente: Observable<string[]>;
  listaProductos: any = new Array();
  listaClientes: any = new Array();

  productoActual: any;
  clienteActual: any;
  listaDetalleProductos: any = new Array();
  valorTotal:number = 0;
  cliente: FormControl = new FormControl({ value: '', disabled: false }, [Validators.required]);

  displayedColumns: string[] = ['nombre', 'valor', 'cantidad', 'total'];
  dataSource = new MatTableDataSource<any>();
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(
    private dialogRef: MatDialogRef<DetalleVentaComponent>,
    private _facturaService: FacturaService,
  ) { }

  ngOnInit() {
    this.formVenta = new FormGroup({
      nombre: new FormControl({ value: '', disabled: false }, [Validators.required]),
      valor: new FormControl({ value: '', disabled: true }, [Validators.required]),
      unidades: new FormControl({ value: '', disabled: false }, [Validators.required]),
    });

    this.obtenerProductos();
    this.obtenerClientes();
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();
    return !value ? this.listaProductos : this.listaProductos.filter((x) => (x.nombre === undefined ? '' : x.nombre).toLowerCase().includes(value))
  }

  private _filterCliente(value: string): string[] {
    const filterValue = value.toLowerCase();
    console.log('list', this.listaClientes);

    console.log('name', filterValue);

    return !value ? this.listaClientes : this.listaClientes.filter((x) => (x.nombres === undefined ? '' : x.nombres).toLowerCase().includes(value) || String(x.identifiacion === undefined ? '' : x.identifiacion).toLowerCase().includes(value))
  }

  obtenerProductos() {
    this._facturaService.obtenerProductos()
      .subscribe(
        (respuestaObtenerTodo: any) => {
          let respuesta = JSON.parse(respuestaObtenerTodo);
          console.log(respuesta);
          this.listaProductos = respuesta;
          this.filteredOptions = this.formVenta.controls['nombre'].valueChanges.pipe(
            startWith(''),
            map((value: any) => this._filter(value))
          );
        }, err => {
          console.log(err);
        }
      );
  }

  obtenerClientes() {
    this._facturaService.obtenerClientes()
      .subscribe(
        (respuestaObtenerTodo: any) => {
          let respuesta = JSON.parse(respuestaObtenerTodo);
          console.log(respuesta);
          this.listaClientes = respuesta;
          this.filteredOptionsCliente = this.cliente.valueChanges.pipe(
            startWith(''),
            map((value: any) => this._filterCliente(value))
          );
          console.log(this.filteredOptionsCliente );
          
        }, err => {
          console.log(err);
        }
      );
  }

  seleccionarProducto(producto) {
    console.log(producto);
    this.formVenta.controls['valor'].setValue(producto.valorUnidad);
    this.productoActual = producto;
  }

  seleccionarCliente(cliente){
    this.clienteActual = cliente;
  }

  agregarProducto() {

    if(this.formVenta.invalid){
      return;
    }

    let stock = this.buscarStockProductorPorId(this.productoActual.idProducto);
    console.log(stock);
    if(stock<this.formVenta.controls['unidades'].value){
      alert('La cantidad requeridad supera al momnto disponible en stock');
      return ;
    }
    

    this.listaDetalleProductos.push({
      cantidad: this.formVenta.controls['unidades'].value,
      valorUnidad: this.productoActual.valorUnidad,
      valorTotal: this.productoActual.valorUnidad * this.formVenta.controls['unidades'].value,
      idProducto: this.productoActual.idProducto,
      nombre: this.productoActual.nombre,
    });

    this.valorTotal = this.valorTotal + this.productoActual.valorUnidad * this.formVenta.controls['unidades'].value;
    console.log(this.listaDetalleProductos);
    this.dataSource = new MatTableDataSource<any>(this.listaDetalleProductos);

  }

  vender(){
    let vender = {
      valorTotal:this.valorTotal,
      idCliente: {
        idCliente: this.clienteActual.idCliente
      },
      testFacturaDetalleList:this.listaDetalleProductos
    }

    console.log(vender);

    this._facturaService.crearFactura(vender)
    .subscribe(
      (respuestaObtenerTodo: any) => {
        let respuesta = JSON.parse(respuestaObtenerTodo);
        console.log(respuesta);
        if(respuesta.tipoRespuesta == 1){
          this.dialogRef.close();
          alert("Se ha generado la venta exitosamente");
        }else{
          alert("Se ha encontrado un problema al generar la venta");
        }
      }, err => {
        console.log(err);
      }
    );
    
  }

  buscarStockProductorPorId(idProducto){
    for (let index = 0; index < this.listaProductos.length; index++) {
      const element = this.listaProductos[index];
      if(element.idProducto == idProducto){
        return element.stock
      } 
    }
    return 0;
  }


}
