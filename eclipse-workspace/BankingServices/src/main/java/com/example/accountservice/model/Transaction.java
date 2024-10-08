package com.example.accountservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents a financial transaction associated with an account.
 * Each transaction has a type (credit, debit, hold), an amount, a reference, and a timestamp.
 */
@Entity
public class Transaction {

    /**
     * Enum representing the type of transaction.
     * CREDIT - money added to the account
     * DEBIT - money subtracted from the account
     * HOLD - money on hold and not available
     */
    public enum Type {
        CREDIT, DEBIT, HOLD
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the transaction

    private Long accountId; // The ID of the account associated with this transaction

    private long transactionTime; // The timestamp of when the transaction occurred

    private Type type; // The type of transaction (CREDIT, DEBIT, HOLD)

    private BigDecimal amount; // The amount of money involved in the transaction

    private String reference; // A reference or description for the transaction

    /**
     * Constructs a new Transaction with the specified details.
     *
     * @param accountId The ID of the account associated with the transaction.
     * @param type      The type of transaction (CREDIT, DEBIT, HOLD).
     * @param amount    The amount of the transaction.
     * @param reference A reference or description for the transaction.
     */
    public Transaction(Long accountId, Type type, BigDecimal amount, String reference) {
        // Generate a random unique ID
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.setTransactionTime(System.currentTimeMillis()); // Set the current time as the transaction time
        this.setAccountId(accountId); // Set the associated account ID
        this.type = type; // Set the transaction type
        this.amount = amount; // Set the transaction amount
        this.setReference(reference); // Set the transaction reference
    }

    /**
     * Gets the type of transaction.
     *
     * @return The transaction type (CREDIT, DEBIT, HOLD).
     */
    public Type getType() {
        return type;
    }

    /**
     * Gets the amount of the transaction.
     *
     * @return The transaction amount.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Gets the account ID associated with the transaction.
     *
     * @return The account ID.
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the account ID for the transaction.
     *
     * @param accountId The account ID to set.
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets the time when the transaction occurred.
     *
     * @return The transaction timestamp.
     */
    public long getTransactionTime() {
        return transactionTime;
    }

    /**
     * Sets the time when the transaction occurred.
     *
     * @param transactionTime The transaction timestamp to set.
     */
    public void setTransactionTime(long transactionTime) {
        this.transactionTime = transactionTime;
    }

    /**
     * Gets the reference or description of the transaction.
     *
     * @return The transaction reference.
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the reference or description for the transaction.
     *
     * @param reference The transaction reference to set.
     */
    public void setReference(String reference) {
        this.reference = reference;
    }
}
