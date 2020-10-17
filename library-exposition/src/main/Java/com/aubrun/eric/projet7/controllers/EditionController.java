package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.EditionDto;
import com.aubrun.eric.projet7.business.service.EditionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editions")
public class EditionController {

    private final EditionService editionService;

    public EditionController(EditionService editionService) {
        this.editionService = editionService;
    }

    @GetMapping("/")
    public List<EditionDto> getAllEditions() {
        return this.editionService.findAll();
    }

    @GetMapping("/{id}")
    public EditionDto getEditionById(@PathVariable(value = "id") int editionId) {
        return this.editionService.findById(editionId);
    }

    @PostMapping("/")
    public void createEdition(@RequestBody EditionDto editionDto) {
        editionService.save(editionDto);
    }

    @PutMapping("/edition")
    public void updateEdition(@RequestBody EditionDto editionDto) {
        editionService.update(editionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEdition(@PathVariable("id") int editionId) {
        editionService.delete(editionId);
    }
}
