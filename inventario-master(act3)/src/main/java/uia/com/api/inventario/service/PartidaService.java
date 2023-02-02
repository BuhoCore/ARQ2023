package uia.com.api.inventario.service;

import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import uia.com.api.inventario.repository.ItemRepository;
import uia.com.api.inventario.repository.PartidaRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import uia.com.api.inventario.dto.PartidaDTO;
import uia.com.api.inventario.dto.PartidasDTO;

import uia.com.api.inventario.mapper.ApiMapperPartida;
import uia.com.api.inventario.model.Partida;




import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PartidaService {

    PartidaRepository repositoryPartidas;
    ItemRepository repositoryItem;
    Validator validator;

    @Autowired
    public PartidaService(PartidaRepository repositoryPartidas, ItemRepository repositoryItem, Validator validator) {
        this.repositoryPartidas = repositoryPartidas;
        this.repositoryItem = repositoryItem;
        this.validator = validator;
    }


    public PartidasDTO save(PartidasDTO partida) {
        return saveInformation(partida);
    }

    public PartidasDTO update(PartidasDTO partida) {
        return saveInformation(partida);
    }

    private PartidasDTO saveInformation(PartidasDTO partidas) {

        List<Partida> entities = ApiMapperPartida.INSTANCE.DTOToEntities(partidas.getPartidas());
        List<PartidaDTO> entitiesDTO = new ArrayList<PartidaDTO>();
        PartidasDTO result = new PartidasDTO();

        for (Partida partida : entities) {
            Set<ConstraintViolation<Partida>> violations = validator.validate(partida);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            Partida savedEntity = repositoryPartidas.save(partida);
            entitiesDTO.add(ApiMapperPartida.INSTANCE.entityToDTO(savedEntity));
        }

        result.setPartidas(entitiesDTO);
        return result;
    }
}