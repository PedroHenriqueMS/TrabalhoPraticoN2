package com.atividaden2.desafiopicpay;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.atividaden2.desafiopicpay.wallet.WalletType;

// TODO: Auto-generated Javadoc
/**
 * The Class WalletTypeTest.
 */
public class WalletTypeTest {

    /**
     * Test wallet type values.
     */
    @Test
    public void testWalletTypeValues() {
        assertEquals(1, WalletType.COMUM.getValue());
        assertEquals(2, WalletType.LOJISTA.getValue());
    }
}
