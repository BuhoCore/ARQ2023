import { IItem } from "./ISolicitudMaterial";

export interface IPartida 
{
  subpartidas: import("c:/Users/Grexcold/Desktop/ARQ2023/clase-9-angular-inventario-uia-master/src/app/ISubpartida").ISubpartida[];
			id: string,
			idPartida: string,
            name: string,
            idSubpartida: string,
            nameSubpartida: string,
            idCategoria: string,
            nameCategoria: string,
            nameLote: string,
            cantidad: number,
            minimoNivel: number,
            idProveedor: string
  }

  export interface ISubpartida 
{
			id: string,
			idPartida: string,
            name: string,
            idSubpartida: string,
            nameSubpartida: string,
            idCategoria: string,
            nameCategoria: string,
            nameLote: string,
            cantidad: number,
            minimoNivel: number,
            idProveedor: string
            categorias: ICategoria[]; 
  }

  export interface ICategoria 
{
			id: string,
			idPartida: string,
            name: string,
            idSubpartida: string,
            nameSubpartida: string,
            idCategoria: string,
            nameCategoria: string,
            nameLote: string,
            cantidad: number,
            minimoNivel: number,
            idProveedor: string
            items: IItem[]; 
  }