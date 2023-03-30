import { Component, OnInit, ViewChild } from '@angular/core';




import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { DatosService } from '../datos.service';
import { IItem, ISolicitudMaterial } from '../ISolicitudMaterial';
import { ModalDetailsComponent } from '../modal-details/modal-details.component';
import { ModalEditComponent } from '../modal-edit/modal-edit.component';
import { ModalPartidasComponent } from '../modal-partidas/modal-partidas.component';


;
import {MatPaginatorModule} from '@angular/material/paginator';

import { MatTableDataSource, MatTableModule } from '@angular/material/table';

import { ISubpartida } from '../ISubpartida';
import { ModalEditItemComponent } from '../modal-edit-item/modal-edit-item.component';
import { ICategoria, IPartida } from '../IPartida';
import { ModalCategoriasComponent } from '../modal-categorias/modal-categorias.component';



@Component({
  selector: 'app-modal-items',
  templateUrl: './modal-items.component.html',
  styleUrls: ['./modal-items.component.css']
})
export class ModalItemsComponent implements OnInit {


  items: IItem[] = [];
  categorias: ICategoria[] = [];
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

  
dialog: any;

//selectedPartida?: IPartida;
idPartida: any;
idSubPartida: any;
idCategoria: any;


constructor(public datosPartida:DatosService,  public modal: MatDialog, private Nav: Router) {
  this.idPartida = this.datosPartida.getPartidas();
  this.idSubPartida = this.datosPartida.getIdSubpartidas();
  this.idCategoria = this.datosPartida.getIdCategorias();


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
            this.categorias.forEach(c => {
              if(c.idCategoria === this.idCategoria)
              {
                this.items = c.items;
                console.log(this.items);
              }
          
    })
    console.log(this.categorias);
  }
    
  })

}
console.log(this.categorias);
  
})

})

}



ngOnInit(): void {
                
  this.idPartida = this.datosPartida.getPartidas();
  this.idSubPartida = this.datosPartida.getIdSubpartidas();
  this.idCategoria = this.datosPartida.getIdCategorias();


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
            this.categorias.forEach(c => {
              if(c.idCategoria === this.idCategoria)
              {
                this.items = c.items;
                console.log(this.items);
              }
          
    })
    console.log(this.categorias);
  }
    
  })

}
console.log(this.categorias);
  
})

})

}

onCheckboxChange(e: any) {
}

submit() {
}
}
