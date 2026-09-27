package com.chaithanya.metadata_management_system.controller;

import com.chaithanya.metadata_management_system.dto.MetadataRequest;
import com.chaithanya.metadata_management_system.model.Metadata;
import com.chaithanya.metadata_management_system.service.MetadataService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/metadata")
public class MetadataController {

    private final MetadataService metadataService;

    public MetadataController(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @GetMapping("/customer")
    public Metadata customerMetadata() {
        return metadataService.getCustomerMetadata();
    }

    @GetMapping
    public List<Metadata> getAllMetadata() {
        return metadataService.getAllMetadata();
    }

    @PostMapping("/object")
    public Metadata createMetadata(@RequestBody MetadataRequest request) {
        return metadataService.createMetadata(request);
    }

    @PutMapping("/{id}")
    public Metadata updateMetadata(
            @PathVariable String id,
            @RequestBody MetadataRequest request) {

        return metadataService.updateMetadata(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteMetadata(@PathVariable String id) {
        metadataService.deleteMetadata(id);
    }
}