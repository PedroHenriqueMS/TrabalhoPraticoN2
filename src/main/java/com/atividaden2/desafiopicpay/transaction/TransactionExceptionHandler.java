package com.atividaden2.desafiopicpay.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionExceptionHandler.
 */
@ControllerAdvice
public class TransactionExceptionHandler {
    
    /**
     * Handle.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<Object> handle(InvalidTransactionException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
