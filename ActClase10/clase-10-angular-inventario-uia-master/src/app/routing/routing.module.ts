import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from '../app.component'
import { ModalPartidasComponent } from '../modal-partidas/modal-partidas.component'
import { SolicitudMaterialComponent } from '../solicitud-material/solicitud-material.component'
import { EntregaMaterialComponent } from '../entrega-material/entrega-material.component'
import { EntregaPartidaComponent } from '../entrega-partida/entrega-partida.component';
import { SolicitudEntregaComponent } from '../solicitud-entrega/solicitud-entrega.component';


const routes: Routes = [
  { path: 'home', component: SolicitudMaterialComponent},
  { path: 'consultaPartidas', component: ModalPartidasComponent},
  { path: 'ingresoPartidas', component: EntregaPartidaComponent},
  


  { path: 'solicitudesMaterial', component: SolicitudMaterialComponent},
  { path: 'consultasolicitudesMaterial', component: SolicitudMaterialComponent},
  { path: 'nuevassolicitudesMaterial', component: SolicitudMaterialComponent},

  
  { path: 'consultangreso', component: EntregaMaterialComponent},
  { path: 'nuevasngreso', component:EntregaMaterialComponent},

  { path: 'solicitudEntrega', component: SolicitudEntregaComponent},


 

  { path: '', redirectTo: '/home', pathMatch: 'full' }

];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class RoutingModule { }