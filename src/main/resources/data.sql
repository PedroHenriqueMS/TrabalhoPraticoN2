DELETE FROM TRANSACTIONS;

DELETE FROM WALLETS;

INSERT INTO 
    WALLETS (
        ID, FULL_NAME, CPF, EMAIL, "PASSWORD", "TYPE",  BALANCE
    ) 
    VALUES (1, 'Joao - User', 12345678900,'joao@teste.com', '123456', 1, 1000.00
    );

INSERT INTO 
    WALLETS (
            ID, FULL_NAME, CPF, EMAIL, "PASSWORD", "TYPE",  BALANCE
        ) 
        VALUES (2, 'Maria - Lojista', 12345678901,'maria@teste.com', '123456', 2, 1000.00
        );