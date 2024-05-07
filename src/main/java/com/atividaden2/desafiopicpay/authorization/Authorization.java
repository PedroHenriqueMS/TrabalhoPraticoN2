package com.atividaden2.desafiopicpay.authorization;

// TODO: Auto-generated Javadoc
/**
 * The Record Authorization.
 *
 * @param massage the massage
 */
public record Authorization(
    String massage
) {
    
    /**
     * Checks if is authorized.
     *
     * @return true, if is authorized
     */
    public boolean isAuthorized()  {
        return massage.equals("Authorized");
    }
}
