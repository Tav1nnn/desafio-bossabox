package br.com.otavio.desafiobossabox.util;

import br.com.otavio.desafiobossabox.entities.TagEntity;

public class TagUtil {
    public static TagEntity createTag() {
        return new TagEntity(1L, "api");
    }
}
