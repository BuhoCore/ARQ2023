

import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators, FormArray} from '@angular/forms';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatPaginator, PageEvent} from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { DatosService } from '../datos.service'
import { ICategoria, IPartida, ISubpartida }  from '../IPartida'
import { Router } from '@angular/router';
import { IItem, ISolicitudMaterial } from '../ISolicitudMaterial';
import { SolicitudMaterialComponent } from '../solicitud-material/solicitud-material.component';
import { ModalRevisaBajasComponent } from '../modal-revisa-bajas/modal-revisa-bajas.component';
import { ModalEditItemComponent } from '../modal-edit-item/modal-edit-item.component';
import { ModalPartidasComponent } from '../modal-partidas/modal-partidas.component';
import { ModalCategoriasComponent } from '../modal-categorias/modal-categorias.component';
import { ModalItemsComponent } from '../modal-items/modal-items.component';


@Component({
  selector: 'app-items-new-baja-material',
  templateUrl: './items-new-baja-material.component.html',
  styleUrls: ['./items-new-baja-material.component.css']
})
export class ItemsNewBajaMaterialComponent {

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
    const dialogRef = this.modal.open(ModalItemsComponent, {
      autoFocus: false,
      maxHeight: '90vh' //you can adjust the value as per your view
  });
  
    dialogRef.afterClosed().subscribe((result: any) => {
      console.log(`Dialog result: ${result}`);
    });
  
  }


}
       
  