package com.logistic_management_system.processor;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.logistic_management_system.model.Vitals;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.StreamsBuilder;

public class VitalsStreamProcessor {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void buildTopology(StreamsBuilder builder) {
        KStream<String, String> stream = builder.stream("vitals-topic");

        stream
                .mapValues(value -> {
                    try {
                        return objectMapper.readValue(value, Vitals.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter((key, vitals) -> vitals != null && isCritical(vitals))
                .mapValues(vitals -> {
                    try {
                        return objectMapper.writeValueAsString(vitals);
                    } catch (Exception e) {
                        return "";
                    }
                })
                .to("alerts-topic");
    }

    private boolean isCritical(Vitals v) {
        return v.getHeartRate() > 120 || v.getHeartRate() < 60 || v.getOxygenSaturation() > 180 || v.getOxygenSaturation() < 90
                || v.getBodyTemperature() > 38 || v.getBodyTemperature() < 35 || v.getBloodPressureDiastolic() > 180 || v.getBloodPressureSystolic() > 180;
    }
}
