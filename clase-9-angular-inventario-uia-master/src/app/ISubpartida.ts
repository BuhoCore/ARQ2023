export interface ISubpartida 
{
  categorias: import("c:/Users/Grexcold/Desktop/ARQ2023/clase-9-angular-inventario-uia-master/src/app/IPartida").ICategoria[];
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