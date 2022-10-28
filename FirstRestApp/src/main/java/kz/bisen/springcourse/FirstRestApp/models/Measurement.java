package kz.bisen.springcourse.FirstRestApp.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @Column(name = "measurement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "measurement_value")
    @NotNull(message = "Value should not be empty")
    @Min(value = -100, message = "Value should not be lower that -100")
    @Max(value = 100, message = "Value should not be greater that +100")
    private float value;

    @Column(name = "measurement_is_raining")
    @NotNull(message = "Raining bool should not be empty")
    private boolean isRaining;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    @NotNull(message = "Sensor name should not be empty")
    private Sensor sensor;

    @Column(name = "a_current_time")
    private LocalDateTime currentTime;

    public Measurement(float value, boolean raining, Sensor sensor, LocalDateTime currentTime) {
        this.value = value;
        this.isRaining = raining;
        this.sensor = sensor;
        this.currentTime = currentTime;
    }

    public Measurement() {}

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isRaining() {
        return isRaining;
    }

    public void setRaining(boolean raining) {
        this.isRaining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }
}
