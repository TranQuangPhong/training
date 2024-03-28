package phong.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import phong.kafka.request.BalanceMessage;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class KafkaProducerApplication {
    public static void main(String[] args) {
        Properties config = new Properties();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.CLIENT_ID_CONFIG, "bank-balance-producer");
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        config.put(ProducerConfig.ACKS_CONFIG, "all");
        config.put(ProducerConfig.RETRIES_CONFIG, "3");
        config.put(ProducerConfig.LINGER_MS_CONFIG, "1"); //be careful in production

        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(config);
        BalanceMessage.BalanceMessageBuilder builder = BalanceMessage.builder();
        BalanceMessage balanceMessage;
        ProducerRecord<String, String> producerRecord;

        List<String> users = Arrays.asList("phong", "ronaldo", "trump", "mia khalipha");
        Random random = new Random();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        for (int i = 0; i < 10; i++) {
            balanceMessage = builder
                    .name(users.get(random.nextInt(users.size())))
                    .amount(random.nextDouble())
                    .time(LocalDateTime.now())
                    .build();
            String requestJsonString = objectToJson(objectMapper, balanceMessage);
            System.out.println(requestJsonString);
            producerRecord = new ProducerRecord<>("bank-balance-input", balanceMessage.getName(), requestJsonString);
            producer.send(producerRecord);
            System.out.println("Request sent!");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        producer.flush();
        producer.close();


        System.out.println("END PRODUCER!");
    }

    /**
     * @param object
     * @return
     */
    private static String objectToJson(ObjectMapper objectMapper, Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}