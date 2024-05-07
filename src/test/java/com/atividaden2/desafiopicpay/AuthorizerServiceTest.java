package com.atividaden2.desafiopicpay;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import com.atividaden2.desafiopicpay.authorization.Authorization;
import com.atividaden2.desafiopicpay.authorization.AuthorizerService;
import com.atividaden2.desafiopicpay.transaction.Transaction;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizerServiceTest.
 */
public class AuthorizerServiceTest {

    /** The authorizer service. */
    private AuthorizerService authorizerService;
    
    /** The rest client builder. */
    private RestClient.Builder restClientBuilder;
    
    /** The rest client. */
    private RestClient restClient;
    
    /** The request headers uri spec. */
    private RestClient.RequestHeadersUriSpec requestHeadersUriSpec;
    
    /** The response spec. */
    private RestClient.ResponseSpec responseSpec;

    /**
     * Sets the up.
     */
    @BeforeEach
    public void setUp() {
        restClient = mock(RestClient.class);
        restClientBuilder = mock(RestClient.Builder.class);
        requestHeadersUriSpec = mock(RestClient.RequestHeadersUriSpec.class);
        responseSpec = mock(RestClient.ResponseSpec.class);
        
        when(restClientBuilder.baseUrl(anyString())).thenReturn(restClientBuilder);
        when(restClientBuilder.build()).thenReturn(restClient);
        when(restClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        
        authorizerService = new AuthorizerService(restClientBuilder);
    }

    /**
     * Test authorize successful.
     */
    @Test
    public void testAuthorizeSuccessful() {
        Authorization authorization = new Authorization("Authorized");
        ResponseEntity<Authorization> responseEntity = new ResponseEntity<>(authorization, HttpStatus.OK);
        
        when(responseSpec.toEntity(Authorization.class)).thenReturn(responseEntity);
        
        Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.00"), LocalDateTime.now());
        
        assertDoesNotThrow(() -> authorizerService.authorize(transaction));
    }

    /**
     * Test authorize unauthorized.
     */
    @Test
    public void testAuthorizeUnauthorized() {
        Authorization authorization = new Authorization("NotAuthorized");
        ResponseEntity<Authorization> responseEntity = new ResponseEntity<>(authorization, HttpStatus.OK);
        
        when(responseSpec.toEntity(Authorization.class)).thenReturn(responseEntity);
        
        Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.00"), LocalDateTime.now());
        
        assertThrows(RuntimeException.class, () -> authorizerService.authorize(transaction));
    }
}
