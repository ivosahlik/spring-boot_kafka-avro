package cz.ivosahlik.consumer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.ivosahlik.domain.generated.CoffeeOrder;
import cz.ivosahlik.domain.generated.CoffeeUpdateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CoffeeOrdersConsumer {

    @KafkaListener(topics = {"coffee-orders"}, groupId = "${spring.kafka.consumer.group-id}" )
    public void onMessage(ConsumerRecord<String, CoffeeOrder> consumerRecord) throws JsonProcessingException {
        log.info("ConsumerRecord key : {} , value {}", consumerRecord.key(), consumerRecord.value());
    }

//    @KafkaListener(topics = {"coffee-orders"}, groupId = "${spring.kafka.consumer.group-id}" )
//    public void onMessage(@Payload CoffeeOrder coffeeOrder){
//        log.info("ConsumerRecord id : {}", coffeeOrder.getId());
//    }

//    @KafkaListener(topics = {"coffee-orders"}, groupId = "${spring.kafka.consumer.group-id}")
//    public void onMessage(ConsumerRecord<String, GenericRecord> consumerRecord) {
//        log.info("ConsumerRecord key : {} , value {}", consumerRecord.key(), consumerRecord.value());
//
//        String name = consumerRecord.value().get("name").toString(); // calls Utf8.toString
//        log.info("coffeeOrder name : {}", name);
//
//        var genericRecord = consumerRecord.value();
//
//        if (genericRecord instanceof CoffeeOrder coffeeOrder) {
//            log.info("coffeeOrder : {}", coffeeOrder);
//        } else if (genericRecord instanceof CoffeeUpdateEvent coffeeOrderUpdateEvent) {
//            log.info("coffeeOrderUpdateEvent : {}", coffeeOrderUpdateEvent);
//        }
//    }
}
