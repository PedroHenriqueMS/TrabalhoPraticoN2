package com.atividaden2.desafiopicpay;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.atividaden2.desafiopicpay.wallet.Wallet;
import com.atividaden2.desafiopicpay.wallet.WalletType;

public class WalletTest {

    @Test
    public void testDebit() {
        Wallet wallet = new Wallet(1L, "John Doe", 123456789L, "john@example.com", "password", WalletType.COMUM.getValue(), new BigDecimal("100.00"));
        Wallet debitedWallet = wallet.debit(new BigDecimal("50.00"));
        assertEquals(new BigDecimal("50.00"), debitedWallet.balance());
    }

    @Test
    public void testCredit() {
        Wallet wallet = new Wallet(1L, "John Doe", 123456789L, "john@example.com", "password", WalletType.COMUM.getValue(), new BigDecimal("100.00"));
        Wallet creditedWallet = wallet.credit(new BigDecimal("50.00"));
        assertEquals(new BigDecimal("150.00"), creditedWallet.balance());
    }
}
