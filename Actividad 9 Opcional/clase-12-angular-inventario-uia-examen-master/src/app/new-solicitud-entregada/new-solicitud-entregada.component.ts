
import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { DatosService } from '../datos.service';
import { MatDialog } from '@angular/material/dialog';
import { ModalSubpartidasComponent } from '../modal-subpartidas/modal-subpartidas.component';
import { IPartida } from '../IPartida';

@Component({
  selector: 'app-new-solicitud-entregada',
  templateUrl: './new-solicitud-entregada.component.html',
  styleUrls: ['./new-solicitud-entregada.component.css']
})
export class NewSolicitudEntregadaComponent {

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

  openDialogNew(id:string) {
    console.log("id:"+id);
    this.datosPartida.setIdPartida(id);
    const dialogRef = this.modal.open(ModalSubpartidasComponent, {
      autoFocus: false,
      maxHeight: '90vh' //you can adjust the value as per your view
  });
  
    dialogRef.afterClosed().subscribe((result: any) => {
      console.log(`Dialog result: ${result}`);
    });
  
  }


}
       
  
