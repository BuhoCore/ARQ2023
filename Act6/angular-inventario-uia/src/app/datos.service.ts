import { Injectable } from '@angular/core';


import { HttpClient, HttpHeaders } from '@angular/common/http';
import { IPartida } from '../assets/IPartida';

import { BDenMemoriaService } from './bden-memoria.service';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root',
})
export class DatosService{

  private paridasUrl = 'api/partidas';


  constructor(private http: HttpClient, bd:BDenMemoriaService) { 

  }

  getPartidas(): Observable<IPartida[]> {
    return this.http.get<IPartida[]>(this.paridasUrl);
  }
}
