import { Component } from '@angular/core';
import { IPartida } from 'src/assets/IPartida';
import { DatosService } from '../datos.service';

@Component({
  selector: 'app-partida',
  templateUrl: './partida.component.html',
  styleUrls: ['./partida.component.css']
})
export class PartidaComponent {

  partidas: IPartida[] = [];

  constructor(public datosPartida:DatosService) 
  {

   }

  ngOnInit(): void {
    this.datosPartida.getPartidas().subscribe(
      (data: IPartida[]) => {console.log(data);
        this.partidas = data;
      })

  }
}