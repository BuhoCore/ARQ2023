package uia.com.api.inventario.service;

import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uia.com.api.inventario.controller.UbicacionController;
import uia.com.api.inventario.dto.CategoriaDTO;
import uia.com.api.inventario.dto.SolicitudEntregaDTO;
import uia.com.api.inventario.dto.UbicacionDTO;
import uia.com.api.inventario.model.ControlId;
import uia.com.api.inventario.model.Item;
import uia.com.api.inventario.model.SolicitudEntrega;
import uia.com.api.inventario.model.Ubicacion;
import uia.com.api.inventario.repository.*;

import java.util.ArrayList;

@Service
public class UbicacionService {
    SolicitudEntregaRepository repositorySolicitudEntrega;
    ItemRepository repositoryItem;
    SubpartidaRepository repositorySubpartida;
    PartidaRepository repositoryPartida;
    CategoriaRepository repositoryCategoria;
    UbicacionRepository repositoryUbicacion;
    ControlId idControl;
    ControlId idControlDTO;
    Validator validator;

   @Autowired
    public UbicacionService(SolicitudEntregaRepository repositorySolicitudEntrega,
                                   SubpartidaRepository repositorySubpartida,
                                   PartidaRepository repositoryPartida,
                                   ItemRepository repositoryItem,
                                   CategoriaRepository repositoryCategoria,
                                   UbicacionRepository repositoryUbicacion,
                                   Validator validator) {
        this.repositorySolicitudEntrega = repositorySolicitudEntrega;
        this.repositoryItem = repositoryItem;
        this.repositoryCategoria = repositoryCategoria;
        this.repositorySubpartida = repositorySubpartida;
        this.repositoryPartida = repositoryPartida;
        this.repositoryUbicacion = repositoryUbicacion;
        this.validator = validator;
    }

    public Ubicacion save(UbicacionDTO ubicacion) {
        return saveInformation(ubicacion);
    }
    public Ubicacion Update(UbicacionDTO ubicacion) {
        return saveInformation(ubicacion);
    }

    UbicacionDTO ubicacionDTO;
    private Ubicacion saveInformation(UbicacionDTO ubicacionInDTO) {
        UbicacionDTO  solicitudes_salvados = new UbicacionDTO ();
        // creacion de nueva solicitud de material
        ArrayList<Item> itemsApartados = new ArrayList<Item>();
        SolicitudEntrega solicitudEntrega = new SolicitudEntrega();
        Ubicacion ubicacion = new Ubicacion();
        int itemDisponibles = 0;
        int categoriasApartados = 0;

        Ubicacion entityUbicacion = this.repositoryUbicacion.findByName("Ubicacions").get(0);

        for (int k = 0; k < entityUbicacion.getItems().size(); k++) {
            if (entityUbicacion.getItems().get(k).getEstatus().contentEquals("Reubicado"))
                ++itemDisponibles;
        }


        for (int i = 0; i < ubicacion.getItems().size(); i++) {
            if (itemDisponibles > 0) {
                for (int j = 0; j < entityUbicacion.getItems().size(); j++) {
                    if (entityUbicacion.getItems().get(j).getEstatus().contentEquals("Reubicado")) {
                        entityUbicacion.getItems().get(j).setEstatus("Reubicado");
                        itemsApartados.add(entityUbicacion.getItems().get(j));
                        ++categoriasApartados;
                        --itemDisponibles;
                    }
                }
            }
        }

        return ubicacion;
    }

    }

