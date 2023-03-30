
import { Component, OnInit, Input, Output } from '@angular/core';
import { IIngreso, IIngresoPartidas } from '../IPartida';
import {DatosService} from '../datos.service';

@Component({
  selector: 'app-entrega-partida',
  templateUrl: './entrega-partida.component.html',
  styleUrls: ['./entrega-partida.component.css']
})


export class EntregaPartidaComponent  implements OnInit {
  public peticion = { name: "", id: 0 }

  peticiones: IIngresoPartidas[] = [];
 
    constructor( public datosServicio:DatosService) 
   { 
    
   }
             
   ngOnInit(): void {               
  }
      
  agregar2(idPartida:string, name:string, idSubpartida:string, nameSubpartida:string, idCategoria:string, nameCategoria:string, minimoNivel:string):void {
    name = name.trim();

    var newIngresoPar = <IIngresoPartidas>{};
    
    newIngresoPar.idPartida = idPartida;
    newIngresoPar.name = name;
    newIngresoPar.idSubpartida = idSubpartida;
    newIngresoPar.nameSubpartida = nameSubpartida;
    newIngresoPar.idCategoria = idCategoria;
    newIngresoPar.nameCategoria = nameCategoria;
    newIngresoPar.minimoNivel = Number(minimoNivel);

    if (!name) { return; }
    this.datosServicio.agregaIngresoPartida(newIngresoPar)
      .subscribe((peticion: IIngresoPartidas) => {
        this.peticiones.push(peticion);
      });
  }
  
}
