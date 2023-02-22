package uia.com.api.inventario.dto;

import uia.com.api.inventario.model.Item;

import java.util.ArrayList;

public class UbicacionDTO {
    private String idUbucacion;
    private String Ubicacion;
    private ArrayList<Item> items = new ArrayList<Item>();

    public UbicacionDTO() {
    }

    public UbicacionDTO(String idUbucacion, String ubicacion, ArrayList<Item> items) {
        this.idUbucacion = idUbucacion;
        Ubicacion = ubicacion;
        this.items = items;
    }

    public String getIdUbucacion() {
        return idUbucacion;
    }

    public void setIdUbucacion(String idUbucacion) {
        this.idUbucacion = idUbucacion;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
