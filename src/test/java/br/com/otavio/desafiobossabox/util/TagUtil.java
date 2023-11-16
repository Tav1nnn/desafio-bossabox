package br.com.otavio.desafiobossabox.util;

import br.com.otavio.desafiobossabox.model.dto.TagDTO;
import br.com.otavio.desafiobossabox.model.entities.TagEntity;

public class TagUtil {
    public static TagEntity createTag () {
        return new TagEntity(1L, "api");
    }

    public static TagDTO createTagDTO () {
        return new TagDTO(1L, "api");
    }

    public static TagEntity saveTagEntity () {
        TagEntity tagEntity = new TagEntity();
        tagEntity.setName("api");

        return tagEntity;
    }
}
