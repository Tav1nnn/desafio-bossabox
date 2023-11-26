package br.com.otavio.desafiobossabox.controllers;

import br.com.otavio.desafiobossabox.controllers.exceptions.model.StandardError;
import br.com.otavio.desafiobossabox.model.dto.ToolDTO;
import br.com.otavio.desafiobossabox.services.ToolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tools")
@Tag(name = "Tool Management", description = "APIs for managing tools")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @GetMapping()
    @Operation(summary = "find by tag or all",description = "Get tools by tag or all tools")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved tools",
            content =  @Content(schema = @Schema(implementation = ToolDTO.class))),
            @ApiResponse(responseCode = "404", description = "Tag not found", content = @Content)
    })
    public ResponseEntity<List<ToolDTO>> findByTagOrAll(
            @Parameter(description = "Tag to filter tools")
            @RequestParam(value = "tag", required = false) String tag) {
        List<ToolDTO> tools;

        if (tag != null) {
            tools = toolService.findByTag(tag);
        } else {
            tools = toolService.findAll();
        }

        return ResponseEntity.ok().body(tools);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete", description = "Delete a tool by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tool deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "id not found",
                    content =  @Content(schema = @Schema(implementation = StandardError.class)))
    })
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        toolService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @Operation(summary = "create", description = "Create a new tool")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tool created successfully",
                    content =  @Content(schema = @Schema(implementation = ToolDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input" ,
                    content =  @Content(schema = @Schema(implementation = StandardError.class))),
    })
    public ResponseEntity<ToolDTO> create (@RequestBody ToolDTO toolDTO) {
        ToolDTO newToolDTO = toolService.newTool(toolDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id")
                .buildAndExpand(newToolDTO.getIdTool()).toUri();

        return ResponseEntity.created(uri).body(newToolDTO);
    }

}
