package kz.bisen.springcourse.FirstRestApp.dto;

import javax.validation.constraints.NotEmpty;

public class SensorDTO {
    @NotEmpty(message = "should not be empty")
    private String name;

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

        SensorDTO sensorDTO = (SensorDTO) o;

        return name.equals(sensorDTO.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}