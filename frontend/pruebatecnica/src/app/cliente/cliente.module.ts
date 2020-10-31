import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClienteComponent } from './cliente.component';
import { RouterModule, Routes } from '@angular/router';
import { ClienteService } from './cliente.service';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule, MatPaginatorModule } from '@angular/material';

const routes: Routes = [
  {
    path: '',
    component: ClienteComponent
  }
];


@NgModule({
  declarations: [ClienteComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatTableModule,
    MatPaginatorModule,
    HttpClientModule
  ],
  providers:[
    ClienteService
  ]
})
export class ClienteModule { }
