package br.com.otavio.desafiobossabox.util;

import br.com.otavio.desafiobossabox.entities.TagEntity;
import br.com.otavio.desafiobossabox.repositories.TagRepository;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public void run(String... args) throws Exception {

        TagEntity tag1 = new TagEntity(null, "http");
        TagEntity tag2 = new TagEntity(null, "node");
        TagEntity tag3 = new TagEntity(null, "json");

        tagRepository.saveAll(Arrays.asList(tag1,tag2,tag3));
    }
}
