-- Delete all existing transactions
DELETE FROM TRANSACTIONS;

-- Delete all existing wallets
DELETE FROM WALLETS;

-- Insert a new user wallet
INSERT INTO 
    WALLETS (
        ID, FULL_NAME, CPF, EMAIL, "PASSWORD", "TYPE",  BALANCE
    ) 
    VALUES (1, 'Joao - User', 12345678900,'joao@teste.com', '123456', 1, 1000.00
    );

-- Insert a new merchant wallet
INSERT INTO 
    WALLETS (
            ID, FULL_NAME, CPF, EMAIL, "PASSWORD", "TYPE",  BALANCE
        ) 
        VALUES (2, 'Maria - Lojista', 12345678901,'maria@teste.com', '123456', 2, 1000.00
        );