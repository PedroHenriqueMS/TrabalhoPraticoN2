package com.atividaden2.desafiopicpay.transaction;

public class InvalidTransactionException extends  RuntimeException {
    public  InvalidTransactionException(String message) {
        super(message);
    }
}
