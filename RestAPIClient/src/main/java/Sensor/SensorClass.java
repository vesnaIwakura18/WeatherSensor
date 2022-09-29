package Sensor;

import java.util.Objects;

public class SensorClass {
    private String name;

    public SensorClass(String name) {
        this.name = name;
    }
    public SensorClass() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SensorClass sensor = (SensorClass) o;

        return Objects.equals(name, sensor.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
