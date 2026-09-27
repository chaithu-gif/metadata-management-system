package com.chaithanya.metadata_management_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "metadata")
public class Metadata {

    @Id
    private String id;

    private String objectName;
    private String database;
    private List<MetadataField> fields;

    public Metadata() {
    }

    public Metadata(String objectName, String database, List<MetadataField> fields) {
        this.objectName = objectName;
        this.database = database;
        this.fields = fields;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public List<MetadataField> getFields() {
        return fields;
    }

    public void setFields(List<MetadataField> fields) {
        this.fields = fields;
    }
}