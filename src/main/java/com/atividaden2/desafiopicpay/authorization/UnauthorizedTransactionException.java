package com.atividaden2.desafiopicpay.authorization;

public class UnauthorizedTransactionException extends RuntimeException {
    public  UnauthorizedTransactionException(String message) {
        super(message);
    }
}
