package com.atividaden2.desafiopicpay.transaction;

import org.springframework.data.repository.ListCrudRepository;

/**
 * The Interface TransactionRepository.
 */
public interface TransactionRepository extends ListCrudRepository<Transaction, Long> {
    
}
