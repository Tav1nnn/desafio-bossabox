package br.com.otavio.desafiobossabox.controllers;

import br.com.otavio.desafiobossabox.model.dto.ToolDTO;
import br.com.otavio.desafiobossabox.services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tools")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @GetMapping()
    public ResponseEntity<List<ToolDTO>> findByTagOrAll(@RequestParam(value = "tag", required = false) String tag) {
        List<ToolDTO> tools;

        if (tag != null) {
            tools = toolService.findByTag(tag);
        } else {
            tools = toolService.findAll();
        }

        return ResponseEntity.ok().body(tools);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        toolService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<ToolDTO> create (@RequestBody ToolDTO toolDTO) {
        ToolDTO newToolDTO = toolService.newTool(toolDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id")
                .buildAndExpand(newToolDTO.getIdTool()).toUri();

        return ResponseEntity.created(uri).body(newToolDTO);
    }

}
