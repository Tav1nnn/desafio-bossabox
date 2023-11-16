package br.com.otavio.desafiobossabox.services;

import br.com.otavio.desafiobossabox.model.dto.TagDTO;
import br.com.otavio.desafiobossabox.model.entities.TagEntity;
import br.com.otavio.desafiobossabox.model.mapper.TagMapper;
import br.com.otavio.desafiobossabox.repositories.TagRepository;
import br.com.otavio.desafiobossabox.services.exceptions.ResourceNotFoundException;
import br.com.otavio.desafiobossabox.util.TagUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class TagServiceTest {

    @InjectMocks
    private TagService tagService;

    @Mock
    private TagRepository tagRepository;

    @Mock
    private TagMapper tagMapper;

    private String validName;
    private String invalidName;



    @BeforeEach
    void setup () {
        validName = "api";
        invalidName = "invalid";

        Mockito.when(tagRepository.existsByName(validName)).thenReturn(true);
        Mockito.when(tagRepository.existsByName(invalidName)).thenReturn(false);
        Mockito.when(tagRepository.findByName(validName)).thenReturn(Optional.of(TagUtil.createTag()));
        Mockito.when(tagRepository.findByName(invalidName)).thenReturn(Optional.empty());
        Mockito.when(tagRepository.save(TagUtil.saveTagEntity())).thenReturn(TagUtil.createTag());
        Mockito.when(tagMapper.toTagDTO(TagUtil.createTag())).thenReturn(TagUtil.createTagDTO());
        Mockito.when(tagMapper.toTagEntity(TagUtil.createTagDTO())).thenReturn(TagUtil.createTag());

    }

    @Test
    public void testExistsByNameWithValidId () {
        boolean result = tagService.existsByName(validName);

        Assertions.assertTrue(result);
        Mockito.verify(tagRepository, Mockito.times(1)).existsByName(validName);
    }

    @Test
    public void testExistsByNameWithInvalidId () {
        boolean result = tagService.existsByName(invalidName);

        Assertions.assertFalse(result);
        Mockito.verify(tagRepository, Mockito.times(1)).existsByName(invalidName);
    }

    @Test
    public void testFindByNameWithValidName () {
        TagDTO dto = tagService.findByName(validName);

        Assertions.assertEquals(1L, dto.getId());
        Assertions.assertEquals("api", dto.getName());
        Mockito.verify(tagRepository, Mockito.times(1)).findByName(validName);
        Mockito.verify(tagMapper, Mockito.times(1)).toTagDTO(TagUtil.createTag());
    }

    @Test
    public void testFindByNameWithInvalidName () {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            tagService.findByName(invalidName);
        });
        Mockito.verify(tagRepository, Mockito.times(1)).findByName(invalidName);
    }

    @Test
    public void testSave () {
        TagDTO dto = tagService.createTag(validName);

        Assertions.assertEquals(1L, dto.getId());
        Assertions.assertEquals("api", dto.getName());
        Mockito.verify(tagRepository, Mockito.times(1)).save(TagUtil.saveTagEntity());
        Mockito.verify(tagMapper, Mockito.times(1)).toTagDTO(TagUtil.createTag());
    }
}
