package br.com.otavio.desafiobossabox.model.mapper;

import br.com.otavio.desafiobossabox.model.dto.TagDTO;
import br.com.otavio.desafiobossabox.model.dto.ToolDTO;
import br.com.otavio.desafiobossabox.model.entities.TagEntity;
import br.com.otavio.desafiobossabox.model.entities.ToolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface TagMapper {


    @Mapping(source = "id", target = "id")
    TagDTO toTagDTO(TagEntity tagEntity);
    @Mapping(source = "id", target = "id")
    TagEntity toTagEntity(TagDTO tagDTO);
}
