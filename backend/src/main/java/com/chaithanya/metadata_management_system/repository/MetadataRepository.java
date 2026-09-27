package com.chaithanya.metadata_management_system.repository;

import com.chaithanya.metadata_management_system.model.Metadata;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetadataRepository extends MongoRepository<Metadata, String> {

}