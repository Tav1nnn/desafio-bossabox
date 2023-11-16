package br.com.otavio.desafiobossabox.model.mapper;

import br.com.otavio.desafiobossabox.model.dto.TagDTO;
import br.com.otavio.desafiobossabox.model.dto.ToolDTO;
import br.com.otavio.desafiobossabox.model.entities.TagEntity;
import br.com.otavio.desafiobossabox.model.entities.ToolEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    ToolDTO toTagDTO(TagEntity tagEntity);
    ToolEntity toTagEntity(TagDTO tagDTO);
}
