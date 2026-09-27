package com.chaithanya.metadata_management_system.service;

import com.chaithanya.metadata_management_system.model.Transaction;
import com.chaithanya.metadata_management_system.repository.TransactionRepository;
import java.util.List;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public Transaction createTransaction(Transaction transaction) {
    LocalDateTime now = LocalDateTime.now();

    transaction.setCreatedAt(now);
    transaction.setCreatedBy("SYSTEM");

    transaction.setUpdatedAt(now);
    transaction.setUpdatedBy("SYSTEM");

    return transactionRepository.save(transaction);
}
public Transaction updateTransaction(String id, Transaction transaction) {

    Transaction existingTransaction = transactionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Transaction not found"));

    existingTransaction.setFromAccount(transaction.getFromAccount());
    existingTransaction.setToAccount(transaction.getToAccount());
    existingTransaction.setAmount(transaction.getAmount());
    existingTransaction.setTransactionType(transaction.getTransactionType());

    existingTransaction.setUpdatedAt(LocalDateTime.now());
    existingTransaction.setUpdatedBy("SYSTEM");

    return transactionRepository.save(existingTransaction);
}
public List<Transaction> getAllTransactions() {
    return transactionRepository.findAll();
}
public Transaction getTransaction(String id) {
    return transactionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Transaction not found"));
}
public void deleteTransaction(String id) {
    transactionRepository.deleteById(id);
}
}