package com.chaithanya.metadata_management_system.model;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {

    @Id
    private String transactionId;

    private String fromAccount;
    private String toAccount;
    private double amount;
    private String transactionType;
    private LocalDateTime createdAt;
private String createdBy;

private LocalDateTime updatedAt;
private String updatedBy;

    public String getTransactionId() {
    return transactionId;
}

public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
}

public String getFromAccount() {
    return fromAccount;
}

public void setFromAccount(String fromAccount) {
    this.fromAccount = fromAccount;
}

public String getToAccount() {
    return toAccount;
}

public void setToAccount(String toAccount) {
    this.toAccount = toAccount;
}

public double getAmount() {
    return amount;
}

public void setAmount(double amount) {
    this.amount = amount;
}

public String getTransactionType() {
    return transactionType;
}

public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
}
public LocalDateTime getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}

public String getCreatedBy() {
    return createdBy;
}

public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
}

public LocalDateTime getUpdatedAt() {
    return updatedAt;
}

public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
}

public String getUpdatedBy() {
    return updatedBy;
}

public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
}
}