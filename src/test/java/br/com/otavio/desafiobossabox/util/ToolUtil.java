package br.com.otavio.desafiobossabox.util;

import br.com.otavio.desafiobossabox.entities.TagEntity;
import br.com.otavio.desafiobossabox.entities.ToolEntity;

public class ToolUtil {
    public static ToolEntity createTool() {
        ToolEntity toolEntity = new ToolEntity("notion", "notion.com", "notion e bom");
        toolEntity.getTagEntitySet().add(TagUtil.createTag());

        return toolEntity;
    }
}
