package com.atividaden2.desafiopicpay;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.atividaden2.desafiopicpay.authorization.Authorization;

public class AuthorizationTest {

    @Test
    public void testIsAuthorizedReturnsTrue() {
        Authorization authorization = new Authorization("Authorized");
        assertTrue(authorization.isAuthorized());
    }

    @Test
    public void testIsAuthorizedReturnsFalse() {
        Authorization authorization = new Authorization("NotAuthorized");
        assertFalse(authorization.isAuthorized());
    }
}
