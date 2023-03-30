import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ICategoria, IPartida } from './IPartida';
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
  
  private idSolicitud: string = "";
  private idSolicitud$ = new BehaviorSubject<string>("");

  private idPartidas: string = "";
  private idPartidas$ = new BehaviorSubject<string>("");

  private idSubpartidas: string = "";
  private idSubpartidas$= new BehaviorSubject<string>("");

  private idCategorias: string = "";
  private idCategorias$ = new BehaviorSubject<string>("");


  
  private solicitudesMaterial = new Observable<ISolicitudMaterial[]>();
  private partidas = new Observable<IPartida[]>();

  private subpartidas = new Observable<ISubpartida[]>();
  private categorias = new Observable<ICategoria[]>();

  constructor(private http: HttpClient) 
  {     
    this.idSolicitud = ""   
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

  getIdPartidas(): string {
    return this.idPartidas;
  }
  setIdPartidas(id:string){
    this.idPartidas=id;
    this.idPartidas$.next(this.idPartidas);
  }

  getIdSubpartidas(): string {
    return this.idSubpartidas;
  }
  setIdSubpartidas(id:string){
    this.idSubpartidas=id;
    this.idSubpartidas$.next(this.idSubpartidas);
  }

  getIdCategorias(): string {
    return this.idCategorias;
  }
  setIdCategorias(id:string){
    this.idCategorias=id;
    this.idCategorias$.next(this.idCategorias);
  }
  
  }

