package kz.bisen.springcourse.FirstRestApp.repositories;

import kz.bisen.springcourse.FirstRestApp.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {
}