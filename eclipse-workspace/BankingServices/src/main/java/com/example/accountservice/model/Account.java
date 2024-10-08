package com.example.accountservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Represents an account entity in the banking system. Each account is
 * associated with a user and maintains a balance.
 */
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Unique identifier for the account

	private String userId; // Identifier for the user associated with this account

	private BigDecimal balance = BigDecimal.ZERO; // Current balance of the account

	/**
	 * Deposits a specified amount into the account and records the transaction.
	 *
	 * @param amount    The amount to deposit into the account.
	 * @param reference A reference or description of the transaction.
	 * @return A Transaction object representing the deposit.
	 */
	public Transaction deposit(BigDecimal amount, String reference) {
		balance = balance.add(amount);
		return new Transaction(id, Transaction.Type.CREDIT, amount, reference);
	}

	/**
	 * Withdraws a specified amount from the account and records the transaction.
	 *
	 * @param amount    The amount to withdraw from the account.
	 * @param reference A reference or description of the transaction.
	 * @return A Transaction object representing the withdrawal.
	 */
	public Transaction withdraw(BigDecimal amount, String reference) {
		balance = balance.subtract(amount);
		return new Transaction(id, Transaction.Type.DEBIT, amount, reference);
	}
	// Getters and Setters

	/**
	 * Gets the current balance of the account.
	 *
	 * @return The current balance.
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * Gets the user ID associated with the account.
	 *
	 * @return The user ID.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user ID for the account.
	 *
	 * @param userId The user ID to set.
	 */

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
