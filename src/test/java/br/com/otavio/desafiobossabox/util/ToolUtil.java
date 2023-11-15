package br.com.otavio.desafiobossabox.util;

import br.com.otavio.desafiobossabox.model.dto.ToolDTO;
import br.com.otavio.desafiobossabox.model.entities.ToolEntity;

import java.util.HashSet;
import java.util.Set;

public class ToolUtil {
    public static ToolEntity createTool () {
        ToolEntity toolEntity = new ToolEntity("notion", "notion.com", "notion e bom");
        toolEntity.getTagEntitySet().add(TagUtil.createTag());

        return toolEntity;
    }

    public static ToolDTO createToolDTO () {
        Set<String> tags = new HashSet<>();
        tags.add("api");

        return new ToolDTO("notion", "notion.com", "notion e bom", tags);
    }
}
