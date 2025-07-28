package com.logistic_management_system.producer;


import com.google.gson.Gson;
import com.logistic_management_system.config.KafkaProducerConfig;
import com.logistic_management_system.model.Vitals;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

public class VitalsProducer {
    private static final String TOPIC = "vitals-topic";
    private static final Random random = new Random();
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws InterruptedException {
        Producer<String, String> producer = KafkaProducerConfig.createProducer();

        while (true) {
            Vitals vitals = generateVitals();
            String json = gson.toJson(vitals);

            producer.send(new ProducerRecord<>(TOPIC, vitals.getPatientId(), json), (metadata, exception) -> {
                if (exception != null) {
                    System.err.println("Failed to send: " + exception.getMessage());
                } else {
                    System.out.println("Sent: " + json);
                }
            });

            Thread.sleep(1000);
        }
    }

    private static Vitals generateVitals() {
        return new Vitals(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                60 + random.nextInt(40),
                36.0 + random.nextDouble() * 3,
                90 + random.nextInt(20),
                60 + random.nextInt(15),
                95 + random.nextInt(5)
        );
    }
}
