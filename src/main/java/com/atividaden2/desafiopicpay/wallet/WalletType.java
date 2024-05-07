package com.atividaden2.desafiopicpay.wallet;

// TODO: Auto-generated Javadoc
/**
 * The Enum WalletType.
 */
public enum WalletType {
    
    /** The comum. */
    COMUM(1), 
 /** The lojista. */
 LOJISTA(2);
    
    /** The value. */
    private int value;

    /**
     * Instantiates a new wallet type.
     *
     * @param value the value
     */
    private  WalletType(int value) { 
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public int getValue()  { 
        return this.value; 
    }  
}
