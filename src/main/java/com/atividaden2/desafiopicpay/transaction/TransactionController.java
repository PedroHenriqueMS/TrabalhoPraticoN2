package com.atividaden2.desafiopicpay.transaction;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionController.
 */
@RestController
@RequestMapping("transaction")
@Tag(name = "Swagger Documentation for Transaction")
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
    @Operation(summary = "Add new Transaction", method = "Post")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "201", description = "Nova transação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar transação"),
    })
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.create(transaction);
    }

    /**
     * List.
     *
     * @return the list
     */
    @Operation(summary = "Get All Transactions", method = "GET")
    @GetMapping
    public List<Transaction> list() {
        return transactionService.list();
    }
    
}
