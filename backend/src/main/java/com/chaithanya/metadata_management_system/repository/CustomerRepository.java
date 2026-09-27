package com.chaithanya.metadata_management_system.repository;

import com.chaithanya.metadata_management_system.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
boolean existsByEmail(String email);
}