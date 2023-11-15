package br.com.otavio.desafiobossabox.repositories;

import br.com.otavio.desafiobossabox.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
