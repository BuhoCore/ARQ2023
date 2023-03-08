import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { IPartida } from '../assets/IPartida';


@Injectable({
  providedIn: 'root',
})
export class BDenMemoriaService implements InMemoryDbService {

   
    createDb(){

        const partidas = [
            {
                    "idPartida": "100",
                     "id": "Material Oficina",
                     "name": "Material Oficina",
                     "idSubpartida": "110",
                     "nameSubpartida": "Silla",
                     "idCategoria": "111",
                     "nameCategoria": "Silla ejecutiva clase 1",
                     "nameLote": "lote1",
                     "cantidad": 5,
                     "minimoNivel": 5,
                     "idProveedor": "700",
      
         },{

            "idPartida": "100",
            "id": "Material Oficina",
            "name": "Material Oficina",
            "idSubpartida": "150",
            "nameSubpartida": "Silla",
            "idCategoria": "133",
            "nameCategoria": "Silla ejecutiva clase 1",
            "nameLote": "lote1",
            "cantidad": 5,
            "minimoNivel": 5,
            "idProveedor": "730",
         }
       ];
         return {partidas};
     }
 }