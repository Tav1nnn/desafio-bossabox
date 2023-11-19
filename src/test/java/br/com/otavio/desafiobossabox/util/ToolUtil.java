package br.com.otavio.desafiobossabox.util;

import br.com.otavio.desafiobossabox.model.dto.ToolDTO;
import br.com.otavio.desafiobossabox.model.entities.TagEntity;
import br.com.otavio.desafiobossabox.model.entities.ToolEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ToolUtil {
    public static ToolEntity createTool () {
        ToolEntity toolEntity = new ToolEntity("notion", "https://www.google.com.br", "notion e bom");
        toolEntity.getTagEntitySet().add(TagUtil.createTag());

        return toolEntity;
    }

    public static ToolDTO createToolDTO () {
        Set<String> tags = new HashSet<>();
        tags.add("api");

        return new ToolDTO("notion", "https://www.google.com.br", "notion e bom", tags);
    }

    public static ToolEntity saveTool () {
        Set<TagEntity> list = new HashSet<>();
        list.add(TagUtil.createTag());

        return new ToolEntity(1L, "notion", "https://www.google.com.br", "notion e bom", list);
    }

    public static ToolDTO saveToolDTO () {
        Set<String> list = new HashSet<>();
        list.add("api");

        return new ToolDTO(1L, "notion", "https://www.google.com.br", "notion e bom", list);
    }

    public static List<ToolDTO> toolDTOList () {
        List<ToolDTO> list = new ArrayList<>();
        list.add(saveToolDTO());

        return list;
    }

    public static List<ToolEntity> toolEntityList () {
        List<ToolEntity> list = new ArrayList<>();
        list.add(saveTool());

        return list;
    }
}
