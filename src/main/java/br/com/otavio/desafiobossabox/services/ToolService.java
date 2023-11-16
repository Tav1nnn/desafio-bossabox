package br.com.otavio.desafiobossabox.services;

import br.com.otavio.desafiobossabox.model.dto.ToolDTO;
import br.com.otavio.desafiobossabox.repositories.ToolRepository;
import br.com.otavio.desafiobossabox.services.validations.LinkValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    @Autowired
    private TagService tagService;

    @Autowired
    private LinkValidator linkValidator;

    public void newTool (ToolDTO toolDTO) {


    }
}
