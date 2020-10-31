import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductoComponent } from './producto.component';
import { Routes, RouterModule } from '@angular/router';
import { FacturaComponent } from '../factura/factura.component';
import { MatPaginatorModule, MatTableModule } from '@angular/material';
import { ProductoService } from './producto.service';
import { HttpClientModule } from '@angular/common/http';

const routes: Routes = [
  {
    path: '',
    component: ProductoComponent
  }
];

@NgModule({
  declarations: [ProductoComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatTableModule,
    MatPaginatorModule,
    HttpClientModule
  ],
  providers:[
    ProductoService
  ]
})
export class ProductoModule { }
