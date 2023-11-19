package br.com.otavio.desafiobossabox.services;

import br.com.otavio.desafiobossabox.model.dto.ToolDTO;
import br.com.otavio.desafiobossabox.model.mapper.TagMapper;
import br.com.otavio.desafiobossabox.model.mapper.ToolMapper;
import br.com.otavio.desafiobossabox.repositories.ToolRepository;
import br.com.otavio.desafiobossabox.util.TagUtil;
import br.com.otavio.desafiobossabox.util.ToolUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ToolServiceTest {
    @InjectMocks
    private ToolService toolService;

    @Mock
    private ToolRepository toolRepository;

    @Mock
    private TagService tagService;

    @Mock
    private TagMapper tagMapper;

    @Mock
    private ToolMapper toolMapper;

    private String validName;
    private String invalidName;

    @BeforeEach
    void setup () {
        validName = "api";
        invalidName = "invalid";

        Mockito.when(tagService.existsByName(validName)).thenReturn(true);
        Mockito.when(tagService.existsByName(invalidName)).thenReturn(false);
        Mockito.when(tagService.findByName(validName)).thenReturn(TagUtil.createTagDTO());
        Mockito.when(tagService.createTag(validName)).thenReturn(TagUtil.createTagDTO());
        Mockito.when(toolRepository.save(ToolUtil.createTool())).thenReturn(ToolUtil.saveTool());
        Mockito.when(tagMapper.toTagDTO(TagUtil.createTag())).thenReturn(TagUtil.createTagDTO());
        Mockito.when(tagMapper.toTagEntity(TagUtil.createTagDTO())).thenReturn(TagUtil.createTag());
        Mockito.when(toolMapper.toToolDTO(ToolUtil.saveTool())).thenReturn(ToolUtil.saveToolDTO());
        Mockito.when(toolMapper.toToolEntity(ToolUtil.createToolDTO())).thenReturn(ToolUtil.createTool());
        Mockito.when(toolRepository.findAll()).thenReturn(ToolUtil.toolEntityList());
    }

    @Test
    public void testNewTool () {
        ToolDTO result = toolService.newTool(ToolUtil.createToolDTO());
        ToolDTO expected = ToolUtil.saveToolDTO();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindAll () {
        Assertions.assertEquals(ToolUtil.toolDTOList(), toolService.findAll());
    }

}
