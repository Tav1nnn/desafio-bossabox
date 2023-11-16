package br.com.otavio.desafiobossabox.repositories;

import br.com.otavio.desafiobossabox.model.entities.ToolEntity;
import br.com.otavio.desafiobossabox.util.ToolUtil;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ToolRepositoryTest {

    @Autowired
    private ToolRepository toolRepository;

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
        ToolEntity toolEntity = ToolUtil.createTool();
        toolEntity.setId(null);

        var toolEntitySave = toolRepository.save(toolEntity);

        Assertions.assertNotNull(toolEntitySave.getId());
        Assertions.assertEquals(1L, toolEntitySave.getTagEntitySet().size());
        Assertions.assertEquals(1L, toolEntitySave.getId());
    }

    @Test
    @Order(2)
    public void testFindByIdValidId () {
        save();
        Optional<ToolEntity> tool = toolRepository.findById(validId);

        Assertions.assertNotNull(tool);
    }

    @Test
    @Order(3)
    public void testFindByIdInvalidId () {
        save();
        Optional<ToolEntity> tool = toolRepository.findById(invalidId);

        Assertions.assertEquals(Optional.empty(), tool);
    }

    @Test
    @Order(4)
    public void testFindAll () {
        save();
        List<ToolEntity> list = toolRepository.findAll();

        Assertions.assertNotNull(list);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    @Order(5)
    public void testCount () {
        save();
        Long count = toolRepository.count();

        Assertions.assertNotNull(count);
        Assertions.assertEquals(conutTotalTag, count);
    }

    @Test
    @Order(6)
    public void testEdit () {
       save();
       ToolEntity toolEntity = ToolUtil.createTool();
       toolEntity.setTitle("newTitle");

        var toolUpdate = toolRepository.save(toolEntity);

        Assertions.assertNotNull(toolUpdate);
        Assertions.assertEquals("newTitle", toolUpdate.getTitle());
    }

    @Test
    @Order(7)
    public void testDelete () {
        save();
        toolRepository.delete(ToolUtil.createTool());

        Assertions.assertFalse(toolRepository.existsById(validId));
    }

    private void save (){
        ToolEntity toolEntity = ToolUtil.createTool();
        toolRepository.save(toolEntity);
    }
}
