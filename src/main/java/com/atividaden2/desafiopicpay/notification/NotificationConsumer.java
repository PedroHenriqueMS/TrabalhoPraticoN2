package com.atividaden2.desafiopicpay.notification;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.atividaden2.desafiopicpay.transaction.Transaction;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationConsumer.
 */
@Service
public class NotificationConsumer {
    
    /** The rest client. */
    private RestClient restClient;

    /**
     * Instantiates a new notification consumer.
     *
     * @param builder the builder
     */
    public NotificationConsumer(RestClient.Builder builder)  {
        this.restClient = builder
        .baseUrl("https://run.mock.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6")
        .build();
    }

    /**
     * Receive notification.
     *
     * @param transaction the transaction
     */
    @KafkaListener(topics = "transaction-notification", groupId = "picpay-desafio-backend")
    public void receiveNotification(Transaction transaction) {

        var response = restClient.get()
        .retrieve()
        .toEntity(Notification.class);

        if (response.getStatusCode().isError() || !response.getBody().message()) {
            throw new NotificationException("Erron sending notification!");
        }
    }
    
}
