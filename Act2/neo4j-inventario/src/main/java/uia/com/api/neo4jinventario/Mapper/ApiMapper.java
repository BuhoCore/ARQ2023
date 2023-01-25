package uia.com.api.neo4jinventario.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import uia.com.api.neo4jinventario.DTO.ItemDTO;
import uia.com.api.neo4jinventario.Model.Item;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ApiMapper {

    ApiMapper INSTANCE = Mappers.getMapper( ApiMapper.class );

    ItemDTO entityToDTO(Item country);
    Item DTOToEntity(ItemDTO country);

    @Mapping(target = "item", ignore = true)

    List<ItemDTO> entityToDTO(Iterable<Item> item);

}
