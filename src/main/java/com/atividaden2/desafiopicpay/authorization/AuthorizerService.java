package com.atividaden2.desafiopicpay.authorization;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.atividaden2.desafiopicpay.transaction.Transaction;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizerService.
 */
@Service
public class AuthorizerService {
    
    /** The rest client. */
    private RestClient restClient;

    /**
     * Instantiates a new authorizer service.
     *
     * @param builder the builder
     */
    public AuthorizerService(RestClient.Builder builder) {
        this.restClient = builder
        .baseUrl("https://run.mocky.io/v3/5795d450-d2e2-4412-8131-73d0293ac1cc")
        .build();
    }

    /**
     * Authorize.
     *
     * @param transaction the transaction
     */
    public void authorize(Transaction transaction) {
        var response = restClient.get()
        .retrieve()
        .toEntity(Authorization.class);

        if (response.getStatusCode().isError() || !response.getBody().isAuthorized()) {
            throw new RuntimeException("Unauthorized transaction");
        }
    }
}

