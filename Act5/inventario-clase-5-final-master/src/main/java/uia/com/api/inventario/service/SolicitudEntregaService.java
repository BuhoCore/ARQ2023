package uia.com.api.inventario.service;

import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uia.com.api.inventario.dto.CategoriaDTO;
import uia.com.api.inventario.dto.SolicitudEntregaDTO;
import uia.com.api.inventario.dto.SolicitudMaterialDTO;
import uia.com.api.inventario.model.*;
import uia.com.api.inventario.repository.*;

import java.util.ArrayList;


@Service
public class SolicitudEntregaService {
    SolicitudEntregaRepository repositorySolicitudEntrega;
    ItemRepository repositoryItem;
    SubpartidaRepository repositorySubpartida;
    PartidaRepository repositoryPartida;
    CategoriaRepository repositoryCategoria;
    ControlId idControl;
    ControlId idControlDTO;

    Validator validator;

    @Autowired
    public SolicitudEntregaService(SolicitudEntregaRepository repositorySolicitudEntrega,
                                   SubpartidaRepository repositorySubpartida,
                                   PartidaRepository repositoryPartida,
                                   ItemRepository repositoryItem,
                                   CategoriaRepository repositoryCategoria,
                                   Validator validator) {
        this.repositorySolicitudEntrega = repositorySolicitudEntrega;
        this.repositoryItem = repositoryItem;
        this.repositoryCategoria = repositoryCategoria;
        this.repositorySubpartida = repositorySubpartida;
        this.repositoryPartida = repositoryPartida;
        this.validator = validator;
    }

    public SolicitudEntrega save(SolicitudEntregaDTO entregas) {
        return saveInformation(entregas);
    }
    public SolicitudEntrega Update(SolicitudEntregaDTO entregas) {
        return saveInformation(entregas);
    }

CategoriaDTO categoriaDTO;
    private SolicitudEntrega saveInformation(SolicitudEntregaDTO EntregaInDTO) {
        SolicitudEntregaDTO solicitudes_salvados = new SolicitudEntregaDTO();
        // creacion de nueva solicitud de material
        ArrayList<Item> itemsApartados = new ArrayList<Item>();
        SolicitudEntrega solicitudEntrega = new SolicitudEntrega();
        int itemDisponibles = 0;
        int categoriasApartados = 0;

        SolicitudEntrega entitySolicitud = this.repositorySolicitudEntrega.findByName("SSM").get(0);

        for (int k = 0; k < entitySolicitud.getItems().size(); k++) {
            if (entitySolicitud.getItems().get(k).getEstatus().contentEquals("Apartado"))
                ++itemDisponibles;
        }

        if (itemDisponibles >= categoriaDTO.getCantidad()) {
            for (int k = 0; k < entitySolicitud.getItems().size(); k++) {
                if (entitySolicitud.getItems().get(k).getEstatus().contentEquals("Apartado")) {
                    entitySolicitud.getItems().get(k).setEstatus("Entregado");
                    itemsApartados.add(entitySolicitud.getItems().get(k));
                }
            }
            ++categoriasApartados;
        }
        if (categoriasApartados > 0) {
            for (int j = 0; j < itemsApartados.size(); j++) {
                this.repositoryItem.save(itemsApartados.get(j));
            }
            solicitudEntrega.setItems(itemsApartados);
            solicitudEntrega.setId(EntregaInDTO.getId());
            solicitudEntrega.setName(EntregaInDTO.getName());
            solicitudEntrega.setEstatus("Entregado");
            solicitudEntrega.setClase("SSM");
            solicitudEntrega.setCantidad(String.valueOf(itemsApartados.size()));
            repositorySolicitudEntrega.save(solicitudEntrega);

        }

        return solicitudEntrega;
    }
}



