package phong.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import phong.kafka.request.BalanceMessage;

import java.util.Properties;

public class KafkaStreamApplication {
    public static void main(String[] args) {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "bank-balance-stream");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        //Disable cache for dev environment
        config.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_DOC, 0);
        config.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE_V2);

        StreamsBuilder builder = new StreamsBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        KStream<String, String> bankBalanceInputStream = builder.stream("bank-balance-input");
        KTable<String, String> bankBalanceTable = bankBalanceInputStream
                .groupByKey()
//                .reduce((inputValue, currentValue) -> aggregateBalance(objectMapper, inputValue, currentValue));
                .aggregate(
                        () -> objectToJson(objectMapper, BalanceMessage.builder().build()),
                        (key, inputValue, currentValue) -> aggregateBalance(objectMapper, inputValue, currentValue)
                );


        bankBalanceTable.toStream().to("bank-balance-output");

        //Send message to output stream
        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.cleanUp();
        streams.start();

        System.out.println(streams);
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close)); //graceful shutdown
    }

    /**
     * @param objectMapper
     * @param inputValue
     * @param currentValue
     * @return
     */
    private static String aggregateBalance(ObjectMapper objectMapper, String inputValue, String currentValue) {
        BalanceMessage message1;
        BalanceMessage message2;
        BalanceMessage messageAgg;
        String messageResult;
        try {
            message1 = objectMapper.readValue(inputValue, BalanceMessage.class);
            message2 = objectMapper.readValue(currentValue, BalanceMessage.class);
            messageAgg = BalanceMessage.builder()
                    .name(message1.getName())
                    .amount(message1.getAmount() + message2.getAmount())
                    .time(message2.getTime())
                    .build();
            messageResult = objectToJson(objectMapper, messageAgg);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return messageResult;
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