package com.chaithanya.metadata_management_system.service;

import com.chaithanya.metadata_management_system.dto.MetadataRequest;
import com.chaithanya.metadata_management_system.model.Metadata;
import com.chaithanya.metadata_management_system.repository.MetadataRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MetadataService {
    public List<Metadata> getAllMetadata() {
    return metadataRepository.findAll();
}
    private final MetadataRepository metadataRepository;

    public MetadataService(MetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
    }

    public Metadata getCustomerMetadata() {
        return metadataRepository.findAll().stream().findFirst().orElse(null);
    }

    public Metadata createMetadata(MetadataRequest request) {

        Metadata metadata = new Metadata(
                request.getObjectName(),
                request.getDatabase(),
                request.getFields()
        );

        return metadataRepository.save(metadata);
    }
    public Metadata updateMetadata(String id, MetadataRequest request) {

    Metadata metadata = metadataRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Metadata not found"));

    metadata.setObjectName(request.getObjectName());
    metadata.setDatabase(request.getDatabase());
    metadata.setFields(request.getFields());
    return metadataRepository.save(metadata);
}
public void deleteMetadata(String id) {
    metadataRepository.deleteById(id);
}
}