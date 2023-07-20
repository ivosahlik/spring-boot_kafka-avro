package cz.ivosahlik;

import cz.ivosahlik.domain.Temperature;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Random;

@Slf4j
@SpringBootApplication
public class CoffeeOrdersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeOrdersServiceApplication.class, args);
    }


//    // Tohle uplne na zacatku vytvori topic s nazvem "topic1"
//    @Bean
//    public NewTopic topic() {
//        return TopicBuilder.name("first_topic")
//                .partitions(10)
//                .replicas(1)
//                .build();
//    }
//
//    @Autowired
//    private KafkaTemplate<String, Temperature> template;
//
//    // Tady je Producer
//    @EventListener(ApplicationReadyEvent.class)
//    public void afterStartup() throws InterruptedException {
//        while (true) {
//            var value = Temperature.newBuilder()
//                    .setName("A")
//                    .setVal(new Random().nextInt(100))
//                    .build();
//            template.send(new ProducerRecord<>("first_topic", null, value));
//            log.info("sent: {}", value);
//            Thread.sleep(100);
//        }
//    }
}
