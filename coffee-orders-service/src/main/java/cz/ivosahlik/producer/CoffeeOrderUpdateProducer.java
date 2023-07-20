package cz.ivosahlik.producer;

import cz.ivosahlik.domain.generated.CoffeeUpdateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class CoffeeOrderUpdateProducer {

    KafkaTemplate<String, CoffeeUpdateEvent> kafkaTemplate;

    public CoffeeOrderUpdateProducer(KafkaTemplate<String, CoffeeUpdateEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CoffeeUpdateEvent coffeeOrderAvro) {

        ProducerRecord<String, CoffeeUpdateEvent> producerRecord = new ProducerRecord<>("coffee-orders",
                coffeeOrderAvro.getId().toString(), coffeeOrderAvro);
        ListenableFuture<SendResult<String, CoffeeUpdateEvent>> listenableFuture
                = kafkaTemplate.send(producerRecord);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, CoffeeUpdateEvent>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(coffeeOrderAvro, ex);
            }

            @Override
            public void onSuccess(SendResult<String, CoffeeUpdateEvent> result) {
                handleSuccess(coffeeOrderAvro, result);
            }
        });
    }

    private void handleFailure(CoffeeUpdateEvent coffeeOrderAvro, Throwable ex) {
        log.error("Error Sending the message for {} and the exception is : {}", coffeeOrderAvro
        , ex.getMessage(), ex);
    }

    private void handleSuccess(CoffeeUpdateEvent coffeeOrderAvro, SendResult<String, CoffeeUpdateEvent> result) {
        log.info("Message sent successfully for the key : {} , and the value is {}" +
                ", partition is {}", coffeeOrderAvro.getId(), coffeeOrderAvro, result.getRecordMetadata()
                .partition());
    }
}
