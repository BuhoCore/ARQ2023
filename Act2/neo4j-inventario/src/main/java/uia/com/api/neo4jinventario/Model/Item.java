package uia.com.api.neo4jinventario.Model;

import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Node("Item")
public class Item implements INivelInventario {

    @Id
    @GeneratedValue
    private Long id;
    @Relationship("items")
    private List<Item> items = new ArrayList<>();
    @Property("name")
    private String name;
    @Property("partida")
    private String partida;
    @Property("subpartida")
    private String subpartida;
    @Property("categoria")
    private String categoria;
    @Property("descripcion")
    private String descripcion;
    @Relationship("proveedor")
    private Proveedor proveedor;

    public Item() {
    }

    public Item(Long id, List<Item> items, String name, String partida, String subpartida, String categoria, String descripcion, Proveedor proveedor) {
        this.id = id;
        this.items = items;
        this.name = name;
        this.partida = partida;
        this.subpartida = subpartida;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


}
