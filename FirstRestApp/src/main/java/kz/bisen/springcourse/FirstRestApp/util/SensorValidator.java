package kz.bisen.springcourse.FirstRestApp.util;

import kz.bisen.springcourse.FirstRestApp.models.Sensor;
import kz.bisen.springcourse.FirstRestApp.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {
    private final SensorsService sensorsService;

    @Autowired
    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Sensor.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Sensor sensor = (Sensor) o;
        if (sensorsService.findSensorByName(sensor.getName()).isPresent()) {
            errors.rejectValue("name", "", "This sensor already exists, choose another one");
        }
    }
}