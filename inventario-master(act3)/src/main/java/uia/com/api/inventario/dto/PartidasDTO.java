package uia.com.api.inventario.dto;

import java.util.ArrayList;
import java.util.List;

public class PartidasDTO {

    private List<PartidaDTO> partidas = new ArrayList<>();

    public PartidasDTO() {
    }

    public PartidasDTO(List<PartidaDTO> partidas) {
        this.partidas = partidas;
    }

    public List<PartidaDTO> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<PartidaDTO> partidas) {
        this.partidas = partidas;
    }
}
