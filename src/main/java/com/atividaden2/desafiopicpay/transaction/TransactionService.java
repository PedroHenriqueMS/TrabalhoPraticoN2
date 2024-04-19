package com.atividaden2.desafiopicpay.transaction;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atividaden2.desafiopicpay.authorization.AuthorizerService;
import com.atividaden2.desafiopicpay.notification.NotificationService;
import com.atividaden2.desafiopicpay.wallet.Wallet;
import com.atividaden2.desafiopicpay.wallet.WalletRepository;
import com.atividaden2.desafiopicpay.wallet.WalletType;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;
    private final AuthorizerService authorizerService;
    private final NotificationService  notificationService;

    public TransactionService(TransactionRepository transactionRepository, WalletRepository walletRepository, 
    AuthorizerService authorizerService, NotificationService notificationService) {
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
        this.authorizerService = authorizerService;
        this.notificationService = notificationService;
    }

    @Transactional
    public Transaction create(Transaction transaction) {
        // 1 - validar
        validate(transaction);

        // 2 - criar a transacao
        var newTransaction = transactionRepository.save(transaction);

        // 3 - debitar da carteira 
        var walletPayer = walletRepository.findById(transaction.payer()).get();
        var walletPayee = walletRepository.findById(transaction.payee()).get();
        walletRepository.save(walletPayer.debit(transaction.value()));
        walletRepository.save(walletPayee.credit(transaction.value()));


        // 4 - chamar sericos externos
        // authorize transaction
        authorizerService.authorize(transaction);
        
        // notificacao
        notificationService.notify(transaction);

        return newTransaction;

    }

    /*
     * - the payer has a common wallet
     * - the payer has enough balance
     * - the payer is not the payee 
     */
    public void validate(Transaction transaction) {
        walletRepository.findById(transaction.payee())
         .map(payee -> walletRepository.findById(transaction.payer())
          .map(payer -> isTransactionValid(transaction, payer) ? transaction : null)
          .orElseThrow(() -> new InvalidTransactionException("Invalid transaction - %s".formatted(transaction))))
        .orElseThrow(() -> new InvalidTransactionException("Invalid transaction - %s".formatted(transaction)));
    }

    public boolean isTransactionValid(Transaction transaction, Wallet payer) {
        return payer.type() == WalletType.COMUM.getValue() &&
        payer.balance().compareTo(transaction.value()) >= 0 &&
         !payer.id().equals(transaction.payee());
    }

    public List<Transaction> list() {
        return transactionRepository.findAll();
    }
}
