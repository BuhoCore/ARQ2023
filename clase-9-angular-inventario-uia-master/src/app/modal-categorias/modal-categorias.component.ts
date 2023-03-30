import { Component, OnInit, ViewChild } from '@angular/core';
import { ISubpartida } from '../ISubpartida';
import { ModalEditItemComponent } from '../modal-edit-item/modal-edit-item.component';
import { ICategoria, IPartida } from '../IPartida';
import { DatosService } from '../datos.service';
import { MatDialog } from '@angular/material/dialog';
import { ModalPartidasComponent } from '../modal-partidas/modal-partidas.component';
import { Router } from '@angular/router';

import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import {MatPaginatorModule} from '@angular/material/paginator';
import { ModalItemsComponent } from '../modal-items/modal-items.component';


@Component({
  selector: 'app-modal-categorias',
  templateUrl: './modal-categorias.component.html',
  styleUrls: ['./modal-categorias.component.css']
})
export class ModalCategoriasComponent implements OnInit {


  categorias: ICategoria[] = [];
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

//selectedPartida?: IPartida;
idPartida: any;
idSubPartida: any;
idCategoria: any;


  constructor(public datosPartida:DatosService,  public modal: MatDialog, private Nav: Router) {

    this.idPartida = this.datosPartida.getPartidas();
    this.idSubPartida = this.datosPartida.getIdSubpartidas();

    this.datosPartida.getPartidas().subscribe((data: IPartida[])=>{
      console.log(data);

      data.forEach(p => {
        if(p.idPartida === this.idPartida)
        {
          this.subpartidas = p.subpartidas;
          this.subpartidas.forEach(s => {
            if(s.idSubpartida === this.idSubPartida)
            {
              this.categorias = s.categorias;
              console.log(this.categorias);
            }
      })
    }
      console.log(this.categorias);
    }
    )

  })
}
 
ngOnInit(): void {
                
  this.idPartida = this.datosPartida.getPartidas();
  this.idSubPartida = this.datosPartida.getIdSubpartidas();

  this.datosPartida.getPartidas().subscribe((data: IPartida[])=>{
    console.log(data);

    data.forEach(p => {
      if(p.idPartida === this.idPartida)
      {
        this.subpartidas = p.subpartidas;
        this.subpartidas.forEach(s => {
          if(s.idSubpartida === this.idSubPartida)
          {
            this.categorias = s.categorias;
            console.log(this.categorias);
          }
    })
  }
    console.log(this.categorias);
  }
  )

})
 }

 openDialogNew5(id:string) {
  console.log("id:"+id);
  this.datosPartida.setIdCategorias(id);
  const dialogRef = this.modal.open(ModalItemsComponent);

  dialogRef.afterClosed().subscribe((result: any) => {
    console.log(`Dialog result: ${result}`);
  });
}

  
}