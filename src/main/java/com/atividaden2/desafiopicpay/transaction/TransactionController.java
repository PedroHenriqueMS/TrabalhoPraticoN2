package com.atividaden2.desafiopicpay.transaction;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionController.
 */
@RestController
@RequestMapping("transaction")
public class TransactionController {

    /** The transaction service. */
    private final TransactionService transactionService;

    /**
     * Instantiates a new transaction controller.
     *
     * @param transactionService the transaction service
     */
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Creates the transaction.
     *
     * @param transaction the transaction
     * @return the transaction
     */
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.create(transaction);
    }

    /**
     * List.
     *
     * @return the list
     */
    @GetMapping
    public List<Transaction> list() {
        return transactionService.list();
    }
    
}
