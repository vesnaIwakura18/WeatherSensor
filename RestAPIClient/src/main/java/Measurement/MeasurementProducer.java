package Measurement;

import Sensor.SensorClass;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MeasurementProducer {
    public static void main(String[] args) {

        Random random = new Random();

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> jsonToSend = new HashMap<>();

        final String addToMeasurementsUrl = "http://localhost:8080/measurements/add";

        for(int i = 0; i < 999; i++) {
            jsonToSend.put("value", random.nextFloat(-100.0f, 100.0f));
            jsonToSend.put("raining", random.nextBoolean());
            jsonToSend.put("sensor", new SensorClass("Test2"));

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToSend);


            String response = restTemplate.postForObject(addToMeasurementsUrl, request, String.class);
            System.out.println(response);
        }
    }
}