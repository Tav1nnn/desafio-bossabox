package br.com.otavio.desafiobossabox.testsEntity;

import br.com.otavio.desafiobossabox.entities.TagEntity;
import br.com.otavio.desafiobossabox.entities.ToolEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ToolEntityTest {

    @Test
    public void testGettersAndSetters() {

    }

    @Test
    public void testToString() {
        TagEntity tagEntity = new TagEntity();
        tagEntity.setId(1L);
        tagEntity.setName("TestTag");

        assertTrue(tagEntity.toString().contains("id=1"));
        assertTrue(tagEntity.toString().contains("name=TestTag"));
    }

    @Test
    public void testEqualsAndHashCode() {
        TagEntity tagEntity1 = new TagEntity(1L, "Tag1");
        TagEntity tagEntity2 = new TagEntity(1L, "Tag1");
        TagEntity tagEntity3 = new TagEntity(2L, "Tag2");

        assertEquals(tagEntity2, tagEntity1);
        assertEquals(tagEntity1.hashCode(), tagEntity2.hashCode());
        assertNotEquals(tagEntity3, tagEntity1);
        assertNotEquals(tagEntity1.hashCode(), tagEntity3.hashCode());
    }
}
