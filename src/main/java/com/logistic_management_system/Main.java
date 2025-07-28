package com.logistic_management_system;

import com.logistic_management_system.config.KafkaStreamConfig;
import com.logistic_management_system.processor.VitalsStreamProcessor;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StreamsBuilder builder = new StreamsBuilder();
        VitalsStreamProcessor processor = new VitalsStreamProcessor();
        processor.buildTopology(builder);

        KafkaStreams streams = new KafkaStreams(builder.build(), KafkaStreamConfig.getStreamProperties());
        streams.start();

        // Shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}