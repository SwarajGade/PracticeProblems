package com.example.accountservice.repository;

import com.example.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for managing {@link Account} entities.
 * 
 * Provides methods to perform CRUD operations and custom queries on the Account entity.
 * Extends the {@link JpaRepository} interface provided by Spring Data JPA.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Retrieves an {@link Account} entity by its ID.
     *
     * @param id The ID of the account to retrieve.
     * @return An {@link Optional} containing the account if found, or an empty Optional if not found.
     */
    Optional<Account> getAccountById(Long id);
}
