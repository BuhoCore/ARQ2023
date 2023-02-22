package uia.com.api.inventario.model;

import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;

public class Ubicacion {

    @Property("idUbicacion")
    private String idUbicacion;
    @Relationship(type = "UBICACION")
    private ArrayList<Lote> lotes = new ArrayList<Lote>();
    @Relationship(type = "LUGAR")
    private ArrayList<Item> items = new ArrayList<Item>();

    public Ubicacion()
    {}

    public Ubicacion(String idUbicacion, ArrayList<Lote> lotes, ArrayList<Item> items) {
        this.idUbicacion = idUbicacion;
        this.lotes = lotes;
        this.items = items;
    }

    public String getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(String idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Lote> lotes) {
        this.lotes = lotes;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
