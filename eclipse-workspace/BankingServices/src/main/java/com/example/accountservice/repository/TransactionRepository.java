package com.example.accountservice.repository;

import com.example.accountservice.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Transaction} entities.
 * 
 * Provides methods to perform CRUD operations on the Transaction entity.
 * Extends the {@link JpaRepository} interface provided by Spring Data JPA.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Additional custom query methods can be defined here if needed
}
