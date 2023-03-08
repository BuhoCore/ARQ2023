import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';






import { SolicitudesComponent } from './solicitudes/solicitudes.component';


import { DatosService } from './datos.service'; 
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';

import { AppComponent } from './app.component';
import { PartidaComponent } from './partida/partida.component';
import { HttpClientModule } from '@angular/common/http';
import { BDenMemoriaService } from './bden-memoria.service';



@NgModule({
  declarations: [
    AppComponent,
    PartidaComponent,
    SolicitudesComponent,
   
  ],
  imports: [
    BrowserModule,
  
    HttpClientModule,

    HttpClientInMemoryWebApiModule.forRoot(
      BDenMemoriaService, { dataEncapsulation: false }
)],
  providers: [DatosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
