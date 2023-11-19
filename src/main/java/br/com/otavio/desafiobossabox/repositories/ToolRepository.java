package br.com.otavio.desafiobossabox.repositories;

import br.com.otavio.desafiobossabox.model.entities.TagEntity;
import br.com.otavio.desafiobossabox.model.entities.ToolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToolRepository extends JpaRepository<ToolEntity, Long> {
    List<ToolEntity> findByTag(TagEntity tagEntity);
}
