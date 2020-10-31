import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FacturaComponent } from './factura.component';
import { Routes, RouterModule } from '@angular/router';
import { FacturaService } from './factura.service';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule, MatPaginatorModule, MatButtonModule, MatDialogModule, MatFormField, MatFormFieldModule, MatInputModule, MatAutocompleteModule } from '@angular/material';
import { DetalleVentaComponent } from '../modales/detalle-venta/detalle-venta.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [
  {
    path: '',
    component: FacturaComponent
  }
];

@NgModule({
  declarations: [
    FacturaComponent,
    DetalleVentaComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes),
    MatTableModule,
    MatPaginatorModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule,
    HttpClientModule,
  ],
  entryComponents:[
    DetalleVentaComponent
  ],
  providers:[
    FacturaService
  ]
})
export class FacturaModule { }
