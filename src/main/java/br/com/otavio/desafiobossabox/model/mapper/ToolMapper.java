package br.com.otavio.desafiobossabox.model.mapper;

import br.com.otavio.desafiobossabox.model.dto.ToolDTO;
import br.com.otavio.desafiobossabox.model.entities.ToolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ToolMapper {

    @Mapping(source = "id", target = "idTool")
    ToolDTO toToolDTO(ToolEntity toolEntity);

    @Mapping(source = "idTool", target = "id")
    ToolEntity toToolEntity(ToolDTO toolDTO);

}
