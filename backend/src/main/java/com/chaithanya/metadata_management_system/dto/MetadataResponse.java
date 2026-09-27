package com.chaithanya.metadata_management_system.dto;

public class MetadataResponse {

    private String message;

    public MetadataResponse() {
    }

    public MetadataResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}