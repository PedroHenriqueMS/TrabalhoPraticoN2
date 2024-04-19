package com.atividaden2.desafiopicpay.authorization;

public record Authorization(
    String massage
) {
    public boolean isAuthorized()  {
        return massage.equals("Authorized");
    }
}
