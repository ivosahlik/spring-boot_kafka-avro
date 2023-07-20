package cz.ivosahlik;

import cz.ivosahlik.domain.Temperature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@SpringBootApplication
public class CoffeeOrdersConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeOrdersConsumerApplication.class, args);
    }

//    // Tohle je Consumer
//    // Kdyz neni nastavena property "spring.kafka.consumer.properties.specific.avro.reader=true", pak vstupem musi byt GenericRecord
//    // Kdyz nastavena je, pak vstupem muze byt GenericRecord nebo Temperature
//    @KafkaListener(id = "my_group_id", topics = "first_topic")
//    public void listen(Temperature value) {
//        log.info("rec.: {}", value);
//    }
}
