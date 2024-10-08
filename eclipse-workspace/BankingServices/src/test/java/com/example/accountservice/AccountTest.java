package com.example.accountservice;

import com.example.accountservice.model.Account;
import com.example.accountservice.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the {@link Account} class.
 *
 * This test class verifies the functionality of deposit and withdrawal operations
 * in the {@link Account} class.
 */
class AccountTest {

    private Account account;

    /**
     * Setup method executed before each test case.
     *
     * Initializes a new {@link Account} object to be used in each test.
     */
    @BeforeEach
    public void setup() {
        // Initialize a new account instance before each test
        account = new Account();
    }

    /**
     * Test case for the {@link Account#deposit(BigDecimal, String)} method.
     *
     * Verifies that deposits correctly update the account balance and
     * return transactions with the correct type and amount.
     */
    @Test
    public void testDeposit() {
        // Perform deposit operations on the account
        Transaction transaction1 = account.deposit(BigDecimal.TEN, "FY 23-24 qtr 2 interest");
        @SuppressWarnings("unused")
        Transaction transaction2 = account.deposit(BigDecimal.ONE, "Transaction XYZ Surcharge waiver");
        
        // Assert that the account balance is correctly updated after the deposits
        assertEquals(BigDecimal.valueOf(11), account.getBalance(), "The account balance after two deposits of 10 and 1 should be 11");
        
        // Verify that the first transaction is a CREDIT type with the correct amount
        assertEquals(Transaction.Type.CREDIT, transaction1.getType());
        assertEquals(BigDecimal.TEN, transaction1.getAmount());
    }

    /**
     * Test case for the {@link Account#withdraw(BigDecimal, String)} method.
     *
     * Verifies that withdrawals correctly update the account balance and
     * return transactions with the correct type and amount.
     */
    @Test
    public void testWithdraw() {
        // Perform a withdrawal operation on the account
        Transaction transaction = account.withdraw(BigDecimal.TEN, "ATM withdrawal");
        
        // Assert that the account balance is correctly updated after the withdrawal
        assertEquals(BigDecimal.valueOf(-10), account.getBalance(), "The account balance after a withdrawal of 10 should be -10");
        
        // Verify that the transaction is a DEBIT type with the correct amount
        assertEquals(Transaction.Type.DEBIT, transaction.getType());
        assertEquals(BigDecimal.TEN, transaction.getAmount());
    }
}
