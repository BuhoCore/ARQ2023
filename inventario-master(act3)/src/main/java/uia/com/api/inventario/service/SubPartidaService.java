package uia.com.api.inventario.service;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import uia.com.api.inventario.dto.SubPartidaDTO;
import uia.com.api.inventario.dto.SubPartidasDTO;

import uia.com.api.inventario.mapper.ApiMapperSubPartida;

import uia.com.api.inventario.model.SubPartida;

import uia.com.api.inventario.repository.PartidaRepository;
import uia.com.api.inventario.repository.SubPartidaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SubPartidaService {


    PartidaRepository repositoryPartidas;
    SubPartidaRepository repositorySubPartidas;
    Validator validator;


    public SubPartidaService(PartidaRepository repositoryPartidas, SubPartidaRepository repositorySubPartidas, Validator validator) {
        this.repositoryPartidas = repositoryPartidas;
        this.repositorySubPartidas = repositorySubPartidas;
        this.validator = validator;
    }

    public SubPartidasDTO save(SubPartidasDTO subpartida) {
        return saveInformation(subpartida);
    }

    public SubPartidasDTO update(SubPartidasDTO subpartida) {
        return saveInformation(subpartida);
    }

    private SubPartidasDTO saveInformation(SubPartidasDTO subpartidas) {

        List<SubPartida> entities = ApiMapperSubPartida.INSTANCE.DTOToEntities(subpartidas.getSubPartidas());
        List<SubPartidaDTO> entitiesDTO = new ArrayList<SubPartidaDTO>();
        SubPartidasDTO result = new SubPartidasDTO();


        for (SubPartida entity : entities) {
            Set<ConstraintViolation<SubPartida>> violations = validator.validate(entity);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            SubPartidaDTO entityDTO = ApiMapperSubPartida.INSTANCE.entityToDTO(repositorySubPartidas.save(entity));
            entitiesDTO.add(entityDTO);
        }
        result.setSubPartidas(entitiesDTO);
        return result;
    }
}
