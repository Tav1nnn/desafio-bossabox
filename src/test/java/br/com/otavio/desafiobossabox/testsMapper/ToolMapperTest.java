package br.com.otavio.desafiobossabox.testsMapper;

import br.com.otavio.desafiobossabox.model.dto.ToolDTO;
import br.com.otavio.desafiobossabox.model.entities.ToolEntity;
import br.com.otavio.desafiobossabox.model.mapper.ToolMapper;
import br.com.otavio.desafiobossabox.util.ToolUtil;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ToolMapperTest {

    @Autowired
    private ToolMapper toolMapper;

    @Test
    @Order(1)
    public void toolEntityToToolDTO (){
        ToolEntity toolEntity = ToolUtil.createTool();

        ToolDTO toolDTO = toolMapper.toToolDTO(toolEntity);

        Assertions.assertEquals(toolEntity.getId(), toolDTO.getIdTool());
        Assertions.assertEquals(toolEntity.getTitle(), toolDTO.getTitle());
        Assertions.assertEquals(toolEntity.getLink(), toolDTO.getLink());
        Assertions.assertEquals(toolEntity.getDescription(), toolDTO.getDescription());
    }

    @Test
    @Order(2)
    public void toolDTOToEntityTool () {
        ToolDTO toolDTO = ToolUtil.createToolDTO();

        ToolEntity toolEntity = toolMapper.toToolEntity(toolDTO);
        Assertions.assertEquals(toolDTO.getIdTool(), toolEntity.getId());
        Assertions.assertEquals(toolDTO.getTitle(), toolEntity.getTitle());
        Assertions.assertEquals(toolDTO.getLink(), toolEntity.getLink());
        Assertions.assertEquals(toolDTO.getDescription(), toolEntity.getDescription());
    }
}
