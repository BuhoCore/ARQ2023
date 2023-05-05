
import { ModalRevisaBajasComponent } from '../modal-revisa-bajas/modal-revisa-bajas.component';

import { Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { DatosService } from '../datos.service';
import { ISolicitudMaterial } from '../ISolicitudMaterial';
import { ModalDetailsComponent } from '../modal-details/modal-details.component';
import { ModalEditComponent } from '../modal-edit/modal-edit.component';
import { ModalPartidasComponent } from '../modal-partidas/modal-partidas.component';
import { ModalRevisaPartidasComponent } from '../modal-revisa-partidas/modal-revisa-partidas.component';
import { IPartida } from '../IPartida';
import { ModalSubpartidasComponent } from '../modal-subpartidas/modal-subpartidas.component';
import { ModalEditItemComponent } from '../modal-edit-item/modal-edit-item.component';
import { ModalItemsComponent } from '../modal-items/modal-items.component';


@Component({
  selector: 'app-new-baja',
  templateUrl: './new-baja.component.html',
  styleUrls: ['./new-baja.component.css']
})
export class NewBajaComponent {
  partidas: IPartida[] = [];
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

  selectedPartida?: IPartida;
 
   constructor(public datosPartida:DatosService,  public modal: MatDialog) 
   {     

   }
                
   ngOnInit(): void {
                
     this.datosPartida.getPartidas().subscribe((data: IPartida[])=>{
       console.log(data);
       this.partidas = data;
     })
     
 
   }

  solicitudMaterial(app: string,  id: any) {
    console.log("id"+id);
    console.log("app"+app);
    console.log(id,app)
    
  }

  openDialogDetails(id:string) {
    console.log("id:"+id);
    this.datosPartida.setIdPartida(id);
    const dialogRef = this.modal.open(ModalRevisaBajasComponent, {
      autoFocus: false,
      maxHeight: '90vh' //you can adjust the value as per your view
  });
  
    dialogRef.afterClosed().subscribe((result: any) => {
      console.log(`Dialog result: ${result}`);
    });
  
  }


}
       
  