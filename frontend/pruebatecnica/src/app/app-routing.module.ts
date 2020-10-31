import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FacturaComponent } from './factura/factura.component';

const routes: Routes = [
 
  {
    path: '',
    redirectTo: 'facturas',
    pathMatch: 'full'
  },
  {
    path: 'facturas',
    loadChildren: () => import('./factura/factura.module').then(m => m.FacturaModule)
  },
  {
    path: 'clientes',
    loadChildren: () => import('./cliente/cliente.module').then(m => m.ClienteModule)
  },
  {
    path: 'productos',
    loadChildren: () => import('./producto/producto.module').then(m => m.ProductoModule)
  },
  { path: '**', pathMatch: 'full', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
