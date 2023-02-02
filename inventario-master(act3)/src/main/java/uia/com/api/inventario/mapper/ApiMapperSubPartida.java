package uia.com.api.inventario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import uia.com.api.inventario.dto.PartidaDTO;
import uia.com.api.inventario.dto.SubPartidaDTO;
import uia.com.api.inventario.model.Partida;
import uia.com.api.inventario.model.SubPartida;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApiMapperSubPartida {

    ApiMapperSubPartida INSTANCE = Mappers.getMapper( ApiMapperSubPartida.class );

    SubPartidaDTO entityToDTO(SubPartida subpartida);
    SubPartida DTOToEntity(SubPartidaDTO subpartida);

    List<SubPartida> entityToDTO(Iterable<SubPartidaDTO> subpartida);
    List<SubPartida> DTOToEntities(List<SubPartidaDTO> subpartidas);


}
