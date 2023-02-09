package gtx18.com.renoult.DTO;

public class CarroDTO {

    private String marca;
    private String modelo;
    private String anno;
    private String color;


    public CarroDTO(){
    }

    public CarroDTO(String marca, String modelo, String anno, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.anno = anno;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}