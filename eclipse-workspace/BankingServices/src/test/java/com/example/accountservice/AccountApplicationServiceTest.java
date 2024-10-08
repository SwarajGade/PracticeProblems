package com.example.accountservice;

import com.example.accountservice.model.Account;
import com.example.accountservice.repository.AccountRepository;
import com.example.accountservice.repository.TransactionRepository;
import com.example.accountservice.service.AccountApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the {@link AccountApplicationService} class.
 *
 * This test class uses Mockito to mock dependencies and JUnit 5 for testing.
 */
@ExtendWith(MockitoExtension.class)
class AccountApplicationServiceTest {

    private Account account;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private AccountApplicationService accountApplicationService;

    /**
     * Setup method executed before each test case.
     *
     * Initializes a new {@link Account} object and configures the mock {@link AccountRepository}
     * to return this account when any account ID is queried.
     */
    @BeforeEach
    public void beforeEach() {
        // Initialize a new account with default settings
        this.account = new Account();
        
        // Mock the behavior of accountRepository to return the initialized account
        Mockito.when(accountRepository.getAccountById(Mockito.anyLong())).thenReturn(Optional.of(account));
    }

    /**
     * Test case for the {@link AccountApplicationService#deposit(Long, BigDecimal, String)} method.
     *
     * Verifies that the deposit method correctly updates the account balance and that a transaction is saved.
     */
    @Test
    public void testDeposit() {
        // Perform a deposit operation on the account
        accountApplicationService.deposit(1L, BigDecimal.TEN, "FY 23-24 qtr 2 interest");
        
        // Assert that the account balance has been correctly updated
        assertEquals(BigDecimal.TEN, account.getBalance());
        
        // Verify that the transaction was saved using the transactionRepository
        Mockito.verify(transactionRepository).save(Mockito.any());
    }
}
