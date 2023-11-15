package br.com.otavio.desafiobossabox.repositories;

import br.com.otavio.desafiobossabox.entities.ToolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository<ToolEntity, Long> {
}
