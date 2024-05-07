package com.atividaden2.desafiopicpay.wallet;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// TODO: Auto-generated Javadoc
/**
 * The Record Wallet.
 *
 * @param id the id
 * @param fullName the full name
 * @param cpf the cpf
 * @param email the email
 * @param password the password
 * @param type the type
 * @param balance the balance
 */
@Table("WALLETS")
public record Wallet(
    @Id Long id,
    String fullName,
    Long cpf,
    String email,
    String password,
    int type,
    BigDecimal balance) {

    /**
     * Debit.
     *
     * @param value the value
     * @return the wallet
     */
    public Wallet debit(BigDecimal value) {
        return new Wallet(id, fullName, cpf, email, password, type, balance.subtract(value));
    }

    /**
     * Credit.
     *
     * @param value the value
     * @return the wallet
     */
    public Wallet credit(BigDecimal value) {
        return new Wallet(id, fullName, cpf, email, password, type, balance.add(value));
    }

}
