package br.com.otavio.desafiobossabox.services;

import br.com.otavio.desafiobossabox.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;


}
