package uia.com.api.inventario.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import uia.com.api.inventario.dto.PartidaDTO;

import java.util.ArrayList;
import java.util.List;

@Node("Categoria")
public class Categoria {

    @Id
    private String id;
    @Property("name")
    private String name;
    @Property("estatus")
    private String estatus;
    @Property("clase")
    private String clase;
    @Property("descripcion")
    private String descripcion;
    private String idPartida;
    private String idSubpartida;
    private String nameSubpartida;
    private String idCategoria;
    private String nameCategoria;
    private String nameLote;
    private String cantidad;
    @Relationship(type = "Contiene")
    private ArrayList<Subpartida> subpartidas = new ArrayList<Subpartida>();
    @Relationship(type = "AGREGO  MAS")
    private ArrayList<Item> items = new ArrayList<Item>();

    public Categoria(String id, String name, String estatus, String clase, String descripcion, String idPartida, String idSubpartida, String nameSubpartida, String idCategoria, String nameCategoria, String nameLote, String cantidad, ArrayList<Subpartida> subpartidas, ArrayList<Item> items) {
        this.id = id;
        this.name = name;
        this.estatus = estatus;
        this.clase = clase;
        this.descripcion = descripcion;
        this.idPartida = idPartida;
        this.idSubpartida = idSubpartida;
        this.nameSubpartida = nameSubpartida;
        this.idCategoria = idCategoria;
        this.nameCategoria = nameCategoria;
        this.nameLote = nameLote;
        this.cantidad = cantidad;
        this.subpartidas = subpartidas;
        this.items = items;
    }

    public Categoria() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public String getIdSubpartida() {
        return idSubpartida;
    }

    public void setIdSubpartida(String idSubpartida) {
        this.idSubpartida = idSubpartida;
    }

    public String getNameSubpartida() {
        return nameSubpartida;
    }

    public void setNameSubpartida(String nameSubpartida) {
        this.nameSubpartida = nameSubpartida;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNameCategoria() {
        return nameCategoria;
    }

    public void setNameCategoria(String nameCategoria) {
        this.nameCategoria = nameCategoria;
    }

    public String getNameLote() {
        return nameLote;
    }

    public void setNameLote(String nameLote) {
        this.nameLote = nameLote;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Subpartida> getSubpartidas() {
        return subpartidas;
    }

    public void setSubpartidas(ArrayList<Subpartida> subpartidas) {
        this.subpartidas = subpartidas;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
