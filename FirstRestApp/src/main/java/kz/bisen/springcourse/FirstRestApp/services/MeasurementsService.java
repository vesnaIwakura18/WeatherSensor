package kz.bisen.springcourse.FirstRestApp.services;

import kz.bisen.springcourse.FirstRestApp.models.Measurement;
import kz.bisen.springcourse.FirstRestApp.repositories.MeasurementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;
    private final SensorsService sensorsService;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository, SensorsService sensorsService) {
        this.measurementsRepository = measurementsRepository;
        this.sensorsService = sensorsService;
    }

    public List<Measurement> findAll() {
        return measurementsRepository.findAll();
    }

    @Transactional
    public void add(Measurement measurement) {
        measurement.setSensor(sensorsService.findSensorByName(measurement.getSensor().getName()).orElse(null));
        measurement.getSensor().getMeasurementList().add(measurement);
        enrichMeasurement(measurement);
        measurementsRepository.save(measurement);
    }

    public void enrichMeasurement(Measurement measurement) {
        measurement.setCurrentTime(LocalDateTime.now());
    }
}