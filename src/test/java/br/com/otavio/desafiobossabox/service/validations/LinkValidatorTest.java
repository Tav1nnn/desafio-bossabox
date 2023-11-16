package br.com.otavio.desafiobossabox.service.validations;

import br.com.otavio.desafiobossabox.services.validations.LinkValidator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LinkValidatorTest {

    private String validLink;
    private String invalidLink;

    private String exceptionLink;

    @BeforeEach
    void setup() {
        validLink = "https://www.google.com.br";
        invalidLink = "https://www.google.com.br/invalid";
        exceptionLink = "google.com.br";
    }

    @Test
    @Order(1)
    public void testValidLink () throws IOException {
        Assertions.assertTrue(LinkValidator.isValid(validLink));
    }

    @Test
    @Order(2)
    public void testInvalidLink () throws IOException {
        Assertions.assertFalse(LinkValidator.isValid(invalidLink));
    }

    @Test
    @Order(3)
    public void testExceptionLink () {
        Assertions.assertThrows(IOException.class, () -> LinkValidator.isValid(exceptionLink));
    }
}
