package Measurement;

import org.springframework.web.client.RestTemplate;

public class MeasurementConsumer {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        final String getMeasurementsUrl = "http://localhost:8080/measurements";

        final String getRainyDaysCountUrl = "http://localhost:8080/measurements/rainyDaysCount";

        String responseGetMeasurements = restTemplate.getForObject(getMeasurementsUrl, String.class);

        String responseGetRainyDaysCount = restTemplate.getForObject(getRainyDaysCountUrl, String.class);

        System.out.println("JSON : " + responseGetMeasurements + "\n");
        System.out.println("Rainy days' count : " + responseGetRainyDaysCount);
    }
}