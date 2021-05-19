package chm.cookieproviderservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CookieService {

    @Value("${cookie.topic}")
    private String COOKIE_TOPIC;

    private final KafkaTemplate kafkaTemplate;

    public CookieService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToKafka(final String cookieType) {
        final String messageKey = UUID.randomUUID().toString();
        System.out.println("Sending to Kafka: " + cookieType);
//        kafkaTemplate.send(COOKIE_TOPIC, messageKey, cookieType);

    }
}
