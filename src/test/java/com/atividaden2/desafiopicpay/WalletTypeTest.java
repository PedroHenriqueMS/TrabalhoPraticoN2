package com.atividaden2.desafiopicpay;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.atividaden2.desafiopicpay.wallet.WalletType;

public class WalletTypeTest {

    @Test
    public void testWalletTypeValues() {
        assertEquals(1, WalletType.COMUM.getValue());
        assertEquals(2, WalletType.LOJISTA.getValue());
    }
}
