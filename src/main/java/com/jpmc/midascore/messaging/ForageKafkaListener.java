package com.jpmc.midascore.messaging;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ForageKafkaListener {

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "forage-midas")
    public void listen(Transaction data) {
        System.out.println("Received Transaction: " + data);
    }

}
