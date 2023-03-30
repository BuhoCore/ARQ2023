

import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { DatosService } from '../datos.service';

import { Component, OnInit, ViewChild } from '@angular/core';
import { ISubpartida } from '../ISubpartida';
import { IPartida } from '../IPartida';
import { ModalCategoriasComponent } from '../modal-categorias/modal-categorias.component';

@Component({
  selector: 'app-modal-subpartidas',
  templateUrl: './modal-subpartidas.component.html',
  styleUrls: ['./modal-subpartidas.component.css']
})

export class ModalSubpartidasComponent implements OnInit {
    subpartidas: ISubpartida[] = [];
    partida: IPartida[] = [];
    pageActual:number=1;
    urlaccion:string = 'assets/icon-tabla/';
    //Material table columns
    displayedColumns: string[] = ['id', 'idPartida', 'idSubpartida', 'idCategoria', 'idProveedor', 'nameCategoria', 'nameSubpartida'];
    //Table Data Source
    dataSource: any;
    @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
    //Dynamic Data Variable
    data: any;
    public totalRows = 0;
    dialog: any;
    selectedPartida?: IPartida; 
    idPartida: any;
    idSubPartida: any;
 
   
  constructor(public datosPartida:DatosService,  public modal: MatDialog, private Nav: Router) 
  {     
    this.idPartida = this.datosPartida.getPartidas();
  
    this.datosPartida.getPartidas().subscribe((data: IPartida[])=>{
      console.log(data);

      data.forEach(p => {
        if(p.idPartida === this.idPartida)
        {
          this.subpartidas = p.subpartidas;
          console.log(this.subpartidas);
        }
      })

  }
)}
ngOnInit(): void {
                
  this.idPartida = this.datosPartida.getPartidas();

  this.datosPartida.getPartidas().subscribe((data: IPartida[])=>{
    console.log(data);

    data.forEach(p => {
      if(p.idPartida === this.idPartida)
      {
        this.subpartidas = p.subpartidas;
        console.log(this.subpartidas);
      }
    })
  })
 }

 openDialogNew4(id:string) {
  console.log("id:"+id);
  this.datosPartida.setIdSubpartidas(id);
  const dialogRef = this.modal.open(ModalCategoriasComponent);

  dialogRef.afterClosed().subscribe((result: any) => {
    console.log(`Dialog result: ${result}`);
  });
}
}
    