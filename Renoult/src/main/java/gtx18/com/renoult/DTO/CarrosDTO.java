package gtx18.com.renoult.DTO;

import java.util.ArrayList;
import java.util.List;

public class CarrosDTO extends CarroDTO{
    List<CarrosDTO> carros = new ArrayList<>();


    public CarrosDTO() {
    }

    public CarrosDTO(String marca, String modelo, String anno, String color) {
        super(marca, modelo, anno, color);
    }

    public List<CarrosDTO> getCarros() {
        return carros;
    }

    public void setCarros(List<CarrosDTO> carros) {
        this.carros = carros;
    }
}

