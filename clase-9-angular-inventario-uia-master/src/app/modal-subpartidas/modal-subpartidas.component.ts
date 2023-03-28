

import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { DatosService } from '../datos.service';
import { ISolicitudMaterial } from '../ISolicitudMaterial';
import { ModalDetailsComponent } from '../modal-details/modal-details.component';
import { ModalEditComponent } from '../modal-edit/modal-edit.component';
import { ModalPartidasComponent } from '../modal-partidas/modal-partidas.component';



import { Component, OnInit, ViewChild } from '@angular/core';
import { ISubpartida } from '../ISubpartida';
import { ModalEditItemComponent } from '../modal-edit-item/modal-edit-item.component';

@Component({
  selector: 'app-modal-subpartidas',
  templateUrl: './modal-subpartidas.component.html',
  styleUrls: ['./modal-subpartidas.component.css']
})
export class ModalSubpartidasComponent implements OnInit {
  subpartidas: ISubpartida[] = [];
    
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
  
    selectedPartida?: ISubpartida;
  dialog: any;
   
     constructor(public datosSubpartida:DatosService,  public modal: MatDialog, private Nav: Router) 
     {     
  
     }
                  
     ngOnInit(): void {
                  
       this.datosSubpartida.getSubpartidas().subscribe((data: ISubpartida[])=>{
         console.log(data);
         this.subpartidas = data;
       })

      }

      
       openDialogNew2() {
        const dialogRef = this.dialog.open(ModalPartidasComponent,{});
      
        dialogRef.afterClosed().subscribe((result: any) => {
          console.log(`Dialog result: ${result}`);
        });
      }
       
  
     onSelect(partida:any)
     {}
  
     
     openDialog(id:any){
      console.log(id)
    }
  
    GiveDataForm(id: any,accion:string) {
      this.Nav.navigate(['partidas']);
          console.log("id"+id);
          console.log("accion"+accion);
    }
  
   partidas(app: string,  id: any) {
      console.log("id"+id);
      console.log("app"+app);
      console.log(id,app)
      switch (app) {
        case 'verEventualidad':
  
          console.log('estaviendo Eventualidad' );
          break;
  
        case 'editarEventualidad':
  
          console.log('estaviendo Eventualidad');
          break;
  
        case 'eliminarEventualiadad':
  
           this.openDialog
  
          break;
      }
    }
    }
         
    