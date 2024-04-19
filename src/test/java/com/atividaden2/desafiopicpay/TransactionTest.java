package com.atividaden2.desafiopicpay;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.atividaden2.desafiopicpay.transaction.Transaction;
import com.atividaden2.desafiopicpay.wallet.Wallet;
import com.atividaden2.desafiopicpay.wallet.WalletType;

public class TransactionTest {

    @Test
    public void testConstructor() {
        Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.05"), LocalDateTime.now());
        
        assertEquals(new BigDecimal("50.05"), transaction.value());
    }

    @Test
public void testDebit() {
    Wallet wallet = new Wallet(1L, "John Doe", 123456789L, "john@example.com", "password", WalletType.COMUM.getValue(), new BigDecimal("100.00"));
    Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.00"), LocalDateTime.now());
    
    Wallet debitedWallet = wallet.debit(transaction.value());
    
    assertEquals(new BigDecimal("50.00"), debitedWallet.balance());
}

@Test
public void testCredit() {
    Wallet wallet = new Wallet(1L, "John Doe", 123456789L, "john@example.com", "password", WalletType.COMUM.getValue(), new BigDecimal("100.00"));
    Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.00"), LocalDateTime.now());
    
    Wallet creditedWallet = wallet.credit(transaction.value());
    
    assertEquals(new BigDecimal("150.00"), creditedWallet.balance());
}

}
