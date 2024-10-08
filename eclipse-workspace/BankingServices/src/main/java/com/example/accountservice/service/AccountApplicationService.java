package com.example.accountservice.service;

import com.example.accountservice.model.Account;
import com.example.accountservice.model.Transaction;
import com.example.accountservice.repository.AccountRepository;
import com.example.accountservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

/**
 * Service class for managing account-related operations.
 * 
 * Provides methods to perform business logic on {@link Account} entities, such as deposit transactions.
 * The class is annotated with {@link Service} to indicate that it's a Spring-managed service component.
 */
@Service
public class AccountApplicationService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * Performs a deposit transaction on the specified account.
     * 
     * This method is annotated with {@link Transactional} to ensure that the operation is executed
     * within a transaction context. If any part of the operation fails, the entire transaction is rolled back.
     *
     * @param accountId The ID of the account to deposit into.
     * @param amount The amount to deposit.
     * @param reference A reference note for the transaction.
     * @throws NoSuchElementException if the account with the specified ID is not found.
     */
    @Transactional
    public void deposit(Long accountId, BigDecimal amount, String reference) {
        // Retrieve the account by ID or throw an exception if not found
        Account account = accountRepository.getAccountById(accountId).orElseThrow();

        // Perform the deposit operation and create a transaction record
        Transaction transaction = account.deposit(amount, reference);

        // Save the transaction and updated account information
        transactionRepository.save(transaction);
        accountRepository.save(account);
    }
}
