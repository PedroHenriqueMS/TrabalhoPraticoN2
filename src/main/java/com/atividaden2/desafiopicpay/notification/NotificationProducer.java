package com.atividaden2.desafiopicpay.notification;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.atividaden2.desafiopicpay.transaction.Transaction;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationProducer.
 */
@Service
public class NotificationProducer {
    
    /** The kafka template. */
    private final  KafkaTemplate<String, Transaction> kafkaTemplate;

    /**
     * Instantiates a new notification producer.
     *
     * @param kafkaTemplate the kafka template
     */
    public NotificationProducer(KafkaTemplate<String, Transaction> kafkaTemplate)  {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Send notification.
     *
     * @param transaction the transaction
     */
    public void sendNotification(Transaction  transaction){
        kafkaTemplate.send("transaction-notification", transaction);
    }
}
