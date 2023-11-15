package br.com.otavio.desafiobossabox.testsRepositories;

import br.com.otavio.desafiobossabox.model.entities.TagEntity;
import br.com.otavio.desafiobossabox.repositories.TagRepository;
import br.com.otavio.desafiobossabox.util.TagUtil;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TagRepositoryTest {

    @Autowired
    private TagRepository tagRepository;

    private Long validId;
    private Long invalidId;
    private Long conutTotalTag;

    @BeforeEach
    void setup() {
        validId = 1L;
        invalidId = 2L;
        conutTotalTag = 1L;
    }

    @Test
    @Order(1)
    public void testSaveTag () {
        TagEntity tagEntity = TagUtil.createTag();
        tagEntity.setId(null);

        tagEntity = tagRepository.save(tagEntity);

        Assertions.assertNotNull(tagEntity.getId());
        Assertions.assertEquals(1L, tagEntity.getId());
    }

    @Test
    @Order(2)
    public void testFindByIdValidId () {
        save();
        Optional<TagEntity> tag = tagRepository.findById(validId);

        Assertions.assertNotNull(tag);
    }

    @Test
    @Order(3)
    public void testFindByIdInvalidId () {
        Optional<TagEntity> tag = tagRepository.findById(invalidId);

        Assertions.assertEquals(Optional.empty(), tag);

    }

    @Test
    @Order(4)
    public void testFindAll () {
        save();
        List<TagEntity> list = tagRepository.findAll();

        for(TagEntity entidade : list) {
            System.out.println("nome" + entidade.getName());
        }

        Assertions.assertNotNull(list);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    @Order(5)
    public void testCount () {
        save();
        Long count = tagRepository.count();

        Assertions.assertNotNull(count);
        Assertions.assertEquals(conutTotalTag, count);
    }

    @Test
    @Order(6)
    public void testEdit () {
        save();
        TagEntity tagEntity = new TagEntity(1L, "newName");

        tagEntity = tagRepository.save(tagEntity);

        Assertions.assertNotNull(tagEntity);
        Assertions.assertEquals("newName", tagEntity.getName());
    }

    @Test
    @Order(7)
    public void testDelete () {
        save();
        tagRepository.delete(TagUtil.createTag());

        Assertions.assertFalse(tagRepository.existsById(validId));
    }


    private void save (){
        TagEntity tagEntity = TagUtil.createTag();
        tagEntity.setId(null);
        tagRepository.save(tagEntity);

    }
}
