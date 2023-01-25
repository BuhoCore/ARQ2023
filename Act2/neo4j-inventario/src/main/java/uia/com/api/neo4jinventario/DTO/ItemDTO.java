package uia.com.api.neo4jinventario.DTO;

import uia.com.api.neo4jinventario.Model.Item;
import uia.com.api.neo4jinventario.Model.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemDTO {
    private Long id;
    private String name;
    private String partida;
    private String subpartida;
    private String categoria;
    private String descripcion;
    private List<Item> items = new ArrayList<>();
    private Proveedor proveedor;

    public ItemDTO() {
    }
    public ItemDTO(Long id, String name, String partida, String subpartida, String categoria, String descripcion, List<Item> items, Proveedor proveedor) {
        this.id = id;
        this.name = name;
        this.partida = partida;
        this.subpartida = subpartida;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.items = items;
        this.proveedor = proveedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getSubpartida() {
        return subpartida;
    }

    public void setSubpartida(String subpartida) {
        this.subpartida = subpartida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

}
