package kz.bisen.springcourse.FirstRestApp.repositories;

import kz.bisen.springcourse.FirstRestApp.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorsRepository extends JpaRepository<Sensor, Integer> {

    Optional<Sensor> findSensorByName(String name);

}
