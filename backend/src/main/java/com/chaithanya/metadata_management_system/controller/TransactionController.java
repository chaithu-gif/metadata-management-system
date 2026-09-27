package com.chaithanya.metadata_management_system.controller;

import com.chaithanya.metadata_management_system.model.Transaction;
import com.chaithanya.metadata_management_system.service.TransactionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping
public Transaction createTransaction(@RequestBody Transaction transaction) {
    return transactionService.createTransaction(transaction);
}
@PutMapping("/{id}")
public Transaction updateTransaction(
        @PathVariable String id,
        @RequestBody Transaction transaction) {

    return transactionService.updateTransaction(id, transaction);
}
@GetMapping
public List<Transaction> getAllTransactions() {
    return transactionService.getAllTransactions();
}
@GetMapping("/{id}")
public Transaction getTransaction(@PathVariable String id) {
    return transactionService.getTransaction(id);
}
@DeleteMapping("/{id}")
public void deleteTransaction(@PathVariable String id) {
    transactionService.deleteTransaction(id);
}
}
