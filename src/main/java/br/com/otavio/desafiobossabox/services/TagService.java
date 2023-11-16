package br.com.otavio.desafiobossabox.services;

import br.com.otavio.desafiobossabox.model.dto.TagDTO;
import br.com.otavio.desafiobossabox.model.entities.TagEntity;
import br.com.otavio.desafiobossabox.model.mapper.TagMapper;
import br.com.otavio.desafiobossabox.repositories.TagRepository;
import br.com.otavio.desafiobossabox.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagMapper tagMapper;

    protected boolean existsByName (String tagName) {
        return tagRepository.existsByName(tagName);
    }

    protected TagDTO findByName (String tagName) {
        TagEntity tagEntity = tagRepository.findByName(tagName)
                .orElseThrow(() -> new ResourceNotFoundException("Name " + tagName + " not found"));

        return tagMapper.toTagDTO(tagEntity);
    }

    protected TagDTO creteTag (String tagName) {
        TagEntity tagEntity = new TagEntity();
        tagEntity.setName(tagName);

        TagEntity newTag =  tagRepository.save(tagEntity);

        return tagMapper.toTagDTO(newTag);
    }
}
