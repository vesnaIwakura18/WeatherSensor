package kz.bisen.springcourse.FirstRestApp.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MeasurementDTO {
    @Min(value = -100, message = "Value should not be lower that -100")
    @Max(value = 100, message = "Value should not be greater that +100")
    @NotNull(message = "Value should not be empty")
    private float value;

    @NotNull(message = "Raining bool should not be empty")
    private boolean isRaining;

    @NotNull(message = "Sensor name should not be empty")
    private SensorDTO sensor;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean getRaining() {
        return isRaining;
    }

    public void setRaining(boolean raining) {
        isRaining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
