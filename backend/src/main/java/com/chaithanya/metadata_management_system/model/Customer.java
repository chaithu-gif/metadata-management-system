package com.chaithanya.metadata_management_system.model;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    private String customerId;

    private String firstName;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
private LocalDateTime updatedAt;
private String createdBy;
private String updatedBy;
    public String getCustomerId() {
    return customerId;
}

public void setCustomerId(String customerId) {
    this.customerId = customerId;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}
public LocalDateTime getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}

public LocalDateTime getUpdatedAt() {
    return updatedAt;
}

public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
}
public String getCreatedBy() {
    return createdBy;
}

public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
}

public String getUpdatedBy() {
    return updatedBy;
}

public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
}
}