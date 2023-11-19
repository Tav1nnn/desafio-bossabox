package br.com.otavio.desafiobossabox.services;

import br.com.otavio.desafiobossabox.model.dto.TagDTO;
import br.com.otavio.desafiobossabox.model.dto.ToolDTO;
import br.com.otavio.desafiobossabox.model.entities.TagEntity;
import br.com.otavio.desafiobossabox.model.entities.ToolEntity;
import br.com.otavio.desafiobossabox.model.mapper.TagMapper;
import br.com.otavio.desafiobossabox.model.mapper.ToolMapper;
import br.com.otavio.desafiobossabox.repositories.ToolRepository;
import br.com.otavio.desafiobossabox.services.exceptions.InvalidLinkException;
import br.com.otavio.desafiobossabox.services.validations.LinkValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    @Autowired
    private TagService tagService;

    @Autowired
    private ToolMapper toolMapper;

    @Autowired
    private TagMapper tagMapper;

    public ToolDTO newTool (ToolDTO toolDTO) {
        linkIsValid(toolDTO.getLink());

        ToolEntity toolEntity = toolMapper.toToolEntity(toolDTO);

        for(String tagName : toolDTO.getTags()) {
           toolEntity.getTagEntitySet().add(tagMapper.toTagEntity(findByNameOrCreateTag(tagName)));
        }

        ToolEntity newtoolEntity = toolRepository.save(toolEntity);

        return returnToolDto(newtoolEntity);
    }

    public List<ToolDTO> findAll () {
        return  getToolDTOS(toolRepository.findAll());
    }

    public List<ToolDTO> findByTag (String tagName) {
        TagDTO tagDTO = tagService.findByName(tagName);

        return getToolDTOS(toolRepository.findByTag(tagMapper.toTagEntity(tagDTO)));
    }

    private void linkIsValid (String link) {
        try {
            if(!LinkValidator.isValid(link)){
                throw new InvalidLinkException("link " + link + "invalid");

            }
        }catch (IOException e) {
            throw new InvalidLinkException(e.getMessage());
        }

    }

    private TagDTO findByNameOrCreateTag (String tagName) {
        if (tagService.existsByName(tagName)) {
            return tagService.findByName(tagName);
        }
        return  tagService.createTag(tagName);
    }

    private ToolDTO returnToolDto (ToolEntity toolEntity) {
        ToolDTO newToolDTO = toolMapper.toToolDTO(toolEntity);

        for (TagEntity tagEntity : toolEntity.getTagEntitySet()) {
            newToolDTO.getTags().add(tagEntity.getName());
        }

        return newToolDTO;
    }

    private List<ToolDTO> getToolDTOS(List<ToolEntity> toolEntityList) {
        List<ToolDTO> toolDTOList = new ArrayList<>();

        for (ToolEntity toolEntity : toolEntityList) {

            ToolDTO toolDTO = toolMapper.toToolDTO(toolEntity);

            for (TagEntity tagEntity : toolEntity.getTagEntitySet()) {
                toolDTO.getTags().add(tagEntity.getName());
            }

            toolDTOList.add(toolDTO);
        }
        return toolDTOList;
    }
}
