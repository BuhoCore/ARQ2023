import { Component, OnInit, ViewChild } from '@angular/core';
import { IPartida } from '../IPartida';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material/dialog';
import { DatosService } from '../datos.service';
import { ModalSubpartidasComponent } from '../modal-subpartidas/modal-subpartidas.component';
import { ModalDetailsComponent } from '../modal-details/modal-details.component';
import { ISolicitudMaterial } from '../ISolicitudMaterial';
import { ModalEditComponent } from '../modal-edit/modal-edit.component';
import { ModalItemsComponent } from '../modal-items/modal-items.component';
import { ConsultaSolicitudEntregadaComponent } from '../consulta-solicitud-entregada/consulta-solicitud-entregada.component';
import { ConsultaIngresoComponent } from '../consulta-ingreso/consulta-ingreso.component';
import { NewSolicitudComponent } from '../new-solicitud/new-solicitud.component';
import { NewPartidaComponent } from '../new-partida/new-partida.component';
import { SolicitudMaterialComponent } from '../solicitud-material/solicitud-material.component';
import { ModalCategoriasComponent } from '../modal-categorias/modal-categorias.component';
import { ModalEditItemComponent } from '../modal-edit-item/modal-edit-item.component';
import { ComponentFactoryResolver, ViewContainerRef } from '@angular/core';

@Component({
  selector: 'app-new-solicitud-entregada',
  templateUrl: './new-solicitud-entregada.component.html',
  styleUrls: ['./new-solicitud-entregada.component.css']
})
export class NewSolicitudEntregadaComponent implements OnInit  {

  
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
  dialog: any;
 
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


  openDialogNew(id:string) {
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
       
  