package com.chaithanya.metadata_management_system.repository;

import com.chaithanya.metadata_management_system.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}