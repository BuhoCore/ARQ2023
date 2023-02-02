package uia.com.api.inventario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import uia.com.api.inventario.dto.PartidaDTO;
import uia.com.api.inventario.model.Partida;


import java.util.List;


@Mapper(componentModel = "spring")
public interface ApiMapperPartida {

    ApiMapperPartida INSTANCE = Mappers.getMapper( ApiMapperPartida.class );

    PartidaDTO entityToDTO(Partida partida);
    Partida DTOToEntity(PartidaDTO partida);


    //@Mapping(target="proveedores", ignore = true)
    List<Partida> entityToDTO(Iterable<PartidaDTO> partida);
    List<Partida> DTOToEntities(List<PartidaDTO> partidas);
}
