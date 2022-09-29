package Sensor;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class SensorProducer {
    public static void main(String[] args) {

        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "Test2");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);

        RestTemplate restTemplate = new RestTemplate();

        final String createNewSensorUrl = "http://localhost:8080/sensors/registration";

        String response = restTemplate.postForObject(createNewSensorUrl, request, String.class);

        System.out.println(response);
    }
}