package uia.com.api.inventario.dto;

import java.util.ArrayList;
import java.util.List;

public class SubPartidasDTO {

    private List<SubPartidaDTO> subpartidas = new ArrayList<>();

    public SubPartidasDTO() {
    }

    public SubPartidasDTO(List<SubPartidaDTO> subpartidas) {
        this.subpartidas = subpartidas;
    }

    public List<SubPartidaDTO> getSubPartidas() {
        return subpartidas;
    }

    public void setSubPartidas(List<SubPartidaDTO> subpartidas) {
        this.subpartidas = subpartidas;
    }

}
