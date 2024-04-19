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

public class AuthorizerServiceTest {

    private AuthorizerService authorizerService;
    private RestClient.Builder restClientBuilder;
    private RestClient restClient;
    private RestClient.RequestHeadersUriSpec requestHeadersUriSpec;
    private RestClient.ResponseSpec responseSpec;

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

    @Test
    public void testAuthorizeSuccessful() {
        Authorization authorization = new Authorization("Authorized");
        ResponseEntity<Authorization> responseEntity = new ResponseEntity<>(authorization, HttpStatus.OK);
        
        when(responseSpec.toEntity(Authorization.class)).thenReturn(responseEntity);
        
        Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.00"), LocalDateTime.now());
        
        assertDoesNotThrow(() -> authorizerService.authorize(transaction));
    }

    @Test
    public void testAuthorizeUnauthorized() {
        Authorization authorization = new Authorization("NotAuthorized");
        ResponseEntity<Authorization> responseEntity = new ResponseEntity<>(authorization, HttpStatus.OK);
        
        when(responseSpec.toEntity(Authorization.class)).thenReturn(responseEntity);
        
        Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.00"), LocalDateTime.now());
        
        assertThrows(RuntimeException.class, () -> authorizerService.authorize(transaction));
    }
}
