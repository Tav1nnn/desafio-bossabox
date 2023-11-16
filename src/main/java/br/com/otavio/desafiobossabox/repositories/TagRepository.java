package br.com.otavio.desafiobossabox.repositories;

import br.com.otavio.desafiobossabox.model.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
    Boolean existsByName (String name);
    Optional<TagEntity> findByName (String name);
}
