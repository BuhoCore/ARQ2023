import { Component, ViewChild } from '@angular/core';

import { MatDialog } from '@angular/material/dialog';
import { DatosService } from '../datos.service';
import { IItem, ISolicitudMaterial } from '../ISolicitudMaterial';
import { ModalEditItemComponent } from '../modal-edit-item/modal-edit-item.component';
import { ModalEditComponent } from '../modal-edit/modal-edit.component';
import { ModalItemsComponent } from '../modal-items/modal-items.component';
import { ModalDetailsComponent } from '../modal-details/modal-details.component';
import { ModalRevisaPartidasComponent } from '../modal-revisa-partidas/modal-revisa-partidas.component';
import { ICategoria, IPartida, ISubpartida } from '../IPartida';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-modal-revisa-bajas',
  templateUrl: './modal-revisa-bajas.component.html',
  styleUrls: ['./modal-revisa-bajas.component.css']
})
export class ModalRevisaBajasComponent {  
  pageActual:number=1;
  public pageSizes = 5;
  public paginaActual = 0;
  public ndxPagina = 0;

  categorias: ICategoria[] = [];
  subpartidas: ISubpartida[] = [];
  items: IItem[] = [];
  urlaccion:string = 'assets/icon-tabla/';
  //Material table columns
  displayedColumns: string[] = ['id', 'idPartida', 'idSubpartida', 'idCategoria', 'idProveedor', 'nameCategoria', 'nameSubpartida'];
  //Table Data Source
  dataSource: any;
  //Dynamic Data Variable
  data: any;
  public totalRows = 0;
  idPartida: any;
  idSubPartida: any;
  idCategoria: any;
  form: FormGroup | undefined;
  checked:boolean=false;
  idRow:string="";
  itemsCarrito: IItem[] = [];
   constructor(public datosPartida:DatosService,  public modal: MatDialog, private Nav: Router) 
   {     
    this.idPartida = this.datosPartida.getIdPartida();
    this.idSubPartida = this.datosPartida.getIdSubpartida();
    this.idCategoria = this.datosPartida.getIdCategoria();

    this.datosPartida.getPartidas().subscribe((data: IPartida[])=>{
      console.log(data);

      data.forEach(p => {
        if(p.idPartida === this.idPartida)
        {
          this.subpartidas = p.subpartidas;
          this.subpartidas.forEach(q => {
            if(q.idSubpartida === this.idSubPartida)
            {
              this.categorias = q.categorias;
              this.categorias.forEach(r => {
                if(r.id === this.idCategoria)
                {
                  this.items = r.items;
                  console.log(this.items);
                }
              })
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
                
    this.idPartida = this.datosPartida.getIdPartida();
    this.idSubPartida = this.datosPartida.getIdSubpartida();
    this.idCategoria = this.datosPartida.getIdCategoria();

    this.datosPartida.getPartidas().subscribe((data: IPartida[])=>{
      console.log(data);

      data.forEach(p => {
        if(p.idPartida === this.idPartida)
        {
          this.subpartidas = p.subpartidas;
          this.subpartidas.forEach(q => {
            if(q.idSubpartida === this.idSubPartida)
            {
              this.categorias = q.categorias;
              this.categorias.forEach(r => {
                if(r.id === this.idCategoria)
                {
                  this.items = r.items;
                  console.log(this.items);
                  this.items.forEach(t=>{
                    t.checked=false;
                  })
                }
              })
              console.log(this.categorias);
            }
          })
        }
          console.log(this.categorias);
          this.initCheckBox();
        }
      )
    })

  }


 initCheckBox()
 {
  this.datosPartida.getItemsCarrito$().subscribe((data: IItem[])=>{
    console.log(data);
    this.itemsCarrito = data;
  })


  this.items.forEach(item=>{
    this.itemsCarrito.forEach(itemCarrito => 
      {
        if(item.id === itemCarrito.id)
        {
          item.checked=true;
        }
      })
  })
 }

  onCheckboxChange(e: any) {
  
    this.initCheckBox();
    console.log(e);
    console.log(e.currentTarget.defaultValue);

    if(e.currentTarget.checked)
    {
      this.items.forEach(item=>{
        if(item.id === e.currentTarget.defaultValue)
            {
              this.datosPartida.setItemCarrito(item);
            }
      })
    }
    else{
      this.datosPartida.unsetItemCarrito(e.currentTarget.defaultValue);
    }

  }
    
  submit(){
    
  }
  
  }
       
  