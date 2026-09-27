package com.chaithanya.metadata_management_system.dto;

import com.chaithanya.metadata_management_system.model.MetadataField;
import java.util.List;

public class MetadataRequest {

    private String objectName;
    private String database;
    private List<MetadataField> fields;

    public MetadataRequest() {
    }

    public MetadataRequest(String objectName, String database) {
        this.objectName = objectName;
        this.database = database;
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