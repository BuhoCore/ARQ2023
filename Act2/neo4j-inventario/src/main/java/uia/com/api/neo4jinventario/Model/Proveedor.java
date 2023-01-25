package uia.com.api.neo4jinventario.Model;

import org.springframework.data.neo4j.core.schema.*;

@Node("Proveedor")
public class Proveedor {
    @Id
    @GeneratedValue
    private Long id;
    @Property("name")
    private String name;
    @Property("estatus")
    private String estatus;
    @Property("clase")
    private String clase;
    private @Relationship Item item;

    public Proveedor() {
    }

    public Proveedor(Long id, String name, String estatus, String clase, Item item) {
        this.id = id;
        this.name = name;
        this.estatus = estatus;
        this.clase = clase;
        this.item = item;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


}
