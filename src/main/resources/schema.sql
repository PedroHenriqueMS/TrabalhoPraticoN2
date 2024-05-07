-- Create a table to store wallets information
CREATE TABLE IF NOT EXISTS WALLETS (
    -- Unique identifier for each wallet
    ID SERIAL  PRIMARY KEY, 
    -- Full name of the wallet's owner
    FULL_NAME VARCHAR(100),
    -- CPF (Brazilian identification number) of the wallet's owner
    CPF BIGINT,
    -- Email address of the wallet's owner
    EMAIL VARCHAR(100),
    -- Password for the wallet (should be stored hashed in a real application)
    "PASSWORD" VARCHAR(100),
    -- Type of wallet (e.g. individual, merchant)
    "TYPE" INT,
    -- Current balance of the wallet
    BALANCE DECIMAL(10, 2)
);

-- Create a unique index on the CPF column to ensure uniqueness
CREATE UNIQUE INDEX IF NOT EXISTS cpf_idx ON WALLETS(CPF);

-- Create a unique index on the EMAIL column to ensure uniqueness
CREATE UNIQUE INDEX IF NOT EXISTS email_idx  ON WALLETS(EMAIL);

-- Create a table to store transactions
CREATE TABLE IF NOT EXISTS TRANSACTIONS (
    -- Unique identifier for each transaction
    ID SERIAL  PRIMARY KEY, 
    -- ID of the payer's wallet
    PAYER INT, 
    -- ID of the payee's wallet
    PAYEE INT, 
    -- Value of the transaction
    "VALUE" DECIMAL(10, 2),
    -- Timestamp of when the transaction was created
    CREATED_AT TIMESTAMP,
    -- Foreign key constraint to ensure the payer's wallet exists
    FOREIGN KEY (PAYER) REFERENCES WALLETS(ID),
    -- Foreign key constraint to ensure the payee's wallet exists
    FOREIGN KEY  (PAYEE) REFERENCES WALLETS(ID)
);