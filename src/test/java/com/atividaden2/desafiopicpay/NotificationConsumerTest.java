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

import com.atividaden2.desafiopicpay.notification.Notification;
import com.atividaden2.desafiopicpay.notification.NotificationConsumer;
import com.atividaden2.desafiopicpay.notification.NotificationException;
import com.atividaden2.desafiopicpay.transaction.Transaction;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationConsumerTest.
 */
public class NotificationConsumerTest {

    /** The notification consumer. */
    private NotificationConsumer notificationConsumer;
    
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
        
        notificationConsumer = new NotificationConsumer(restClientBuilder);
    }

    /**
     * Test receive notification successful.
     */
    @Test
    public void testReceiveNotificationSuccessful() {
        Notification notification = new Notification(true);
        ResponseEntity<Notification> responseEntity = new ResponseEntity<>(notification, HttpStatus.OK);
        
        when(responseSpec.toEntity(Notification.class)).thenReturn(responseEntity);
        
        Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.00"), LocalDateTime.now());
        
        assertDoesNotThrow(() -> notificationConsumer.receiveNotification(transaction));
    }

    /**
     * Test receive notification error.
     */
    @Test
    public void testReceiveNotificationError() {
        Notification notification = new Notification(false);
        ResponseEntity<Notification> responseEntity = new ResponseEntity<>(notification, HttpStatus.OK);
        
        when(responseSpec.toEntity(Notification.class)).thenReturn(responseEntity);
        
        Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.00"), LocalDateTime.now());
        
        assertThrows(NotificationException.class, () -> notificationConsumer.receiveNotification(transaction));
    }
}
