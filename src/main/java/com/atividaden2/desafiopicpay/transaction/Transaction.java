package com.atividaden2.desafiopicpay.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// TODO: Auto-generated Javadoc
/**
 * The Record Transaction.
 *
 * @param id the id
 * @param payer the payer
 * @param payee the payee
 * @param value the value
 * @param createdAt the created at
 */
@Table("TRANSACTIONS")
public record Transaction(
    @Id Long id,
    Long payer,
    Long payee,
    BigDecimal value,
    @CreatedDate LocalDateTime createdAt) {

    /**
     * Instantiates a new transaction.
     *
     * @param id the id
     * @param payer the payer
     * @param payee the payee
     * @param value the value
     * @param createdAt the created at
     */
    public Transaction  {
        value = value.setScale(2);
    }
}
