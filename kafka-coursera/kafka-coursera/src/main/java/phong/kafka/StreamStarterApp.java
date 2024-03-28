package phong.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;

import java.util.Arrays;
import java.util.Properties;

public class StreamStarterApp {
    public static void main(String[] args) {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-starter-app");
//        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "favourite-colour-java");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        //Disable cache for dev environment
        config.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_DOC, 0);

        StreamStarterApp streamStarterApp = new StreamStarterApp();
        //Send message to output stream
        try (KafkaStreams streams = new KafkaStreams(streamStarterApp.initTopology(), config)) {
            streams.start();

            System.out.println(streams);
            Runtime.getRuntime().addShutdownHook(new Thread(streams::close)); //graceful shutdown
        }
    }

    /**
     *
     * @return
     */
    public Topology initTopology(){

        StreamsBuilder builder = new StreamsBuilder();

        //Words count
        KStream<String, String> wordCountInput = builder.stream("word-count-input");
        KTable<String, Long> wordCounts = wordCountInput
                .mapValues(textLine -> textLine.toLowerCase())
                .flatMapValues(lowerCaseTextLine -> Arrays.asList(lowerCaseTextLine.split(" ")))
                .selectKey((ignoredKey, word) -> word)
                .groupByKey()
                .count(Materialized.as("Counts"));
        wordCounts.toStream().to("word-count-output");

        //Favourite color
//        KStream<String, String> favouriteColorInputStream = builder.stream("favourite-color-input");
//        KStream<String, String> favouriteColorsStream = favouriteColorInputStream
//                .selectKey((key, value) -> value.split(",")[0])
//                .mapValues(textLine -> (textLine.split(",").length > 1) ? textLine.split(",")[1] : "default-color");
//        favouriteColorsStream.to("favourite-color-input-for-ktable"); //Intermediate topic
//
//        KTable<String, String> favouriteColorInputTable = builder.table("favourite-color-input-for-ktable");
//        KTable<String, Long> favouriteColorsTable = favouriteColorInputTable
////                .groupBy((key, value) -> value)
//                .groupBy((key, value) -> new KeyValue<>(value, value))
//                .count(Materialized.as("count-favourite-color"));
////        favouriteColors.toStream().foreach(((key, value) -> System.out.println("key = " + key + ", value = " + value)));
//        favouriteColorsTable.toStream().to("favourite-color-output");

        return builder.build();
    }
}