package br.com.otavio.desafiobossabox.model.mapper;

import br.com.otavio.desafiobossabox.model.dto.TagDTO;
import br.com.otavio.desafiobossabox.model.entities.TagEntity;
import br.com.otavio.desafiobossabox.util.TagUtil;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TagMapperTest {

    @Autowired
    private TagMapper tagMapper;

    @Test
    @Order(1)
    public void testToTagDTO (){
        TagEntity tagEntity = TagUtil.createTag();

        TagDTO dto = tagMapper.toTagDTO(tagEntity);

        Assertions.assertEquals(tagEntity.getId(), dto.getId());
        Assertions.assertEquals(tagEntity.getName(), dto.getName());
    }

    @Test
    @Order(2)
    public void testToTagEntity (){
        TagDTO dto = TagUtil.createTagDTO();

        TagEntity tagEntity = tagMapper.toTagEntity(dto);

        Assertions.assertEquals(tagEntity.getId(), dto.getId());
        Assertions.assertEquals(tagEntity.getName(), dto.getName());
    }

}
