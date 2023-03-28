import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { IPartida } from './IPartida';
import { ISolicitudMaterial } from './ISolicitudMaterial';
import { BehaviorSubject, Observable } from 'rxjs';
import { ISubpartida } from './ISubpartida';

@Injectable({
  providedIn: 'root',
})
export class DatosService {
   //inventarioUrl = "http://localhost:8080/inventario";

  solicitudesArchivoURL: string = '/assets/solicitudesMaterial.json';
  partidasArchivoURL: string = '/assets/partidas.json';
  subPartidasArchivoURL: string = '/assets/subPartidas.json';
  
  private idSolicitud: string = "";
  private idSolicitud$ = new BehaviorSubject<string>("");
  
  private solicitudesMaterial = new Observable<ISolicitudMaterial[]>();
  private partidas = new Observable<IPartida[]>();
  private subPartidas = new Observable<ISubpartida[]>();

  constructor(private http: HttpClient) 
  {     
    this.idSolicitud = ""   
  }



  getSubpartidas(): Observable<ISubpartida[]> {
    this.subPartidas = this.http.get<ISubpartida[]>(this.subPartidasArchivoURL);
    return this.subPartidas;    
  }
 
  getSolicitudesMaterial(): Observable<ISolicitudMaterial[]> {
    this.solicitudesMaterial = this.http.get<ISolicitudMaterial[]>(this.solicitudesArchivoURL);
    return this.solicitudesMaterial;    
  }

  getPartidas(): Observable<IPartida[]> {
    this.partidas = this.http.get<IPartida[]>(this.partidasArchivoURL);
    return this.partidas;
  }

  setIdSolicitud(id:string)
  {
    this.idSolicitud=id;
    this.idSolicitud$.next(this.idSolicitud);;
  }
  
  getIdSolicitudMaterial(): string {
    return this.idSolicitud;
  } 
}