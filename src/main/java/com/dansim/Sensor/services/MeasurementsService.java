package com.dansim.Sensor.services;

import com.dansim.Sensor.models.Measurements;
import com.dansim.Sensor.repositories.MeasurementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {
    private final SensorsService sensorsService;
    private final MeasurementsRepository measurementsRepository;

    @Autowired
    public MeasurementsService(SensorsService sensorsService, MeasurementsRepository measurementsRepository) {
        this.sensorsService = sensorsService;
        this.measurementsRepository = measurementsRepository;
    }
    @Transactional
    public void save(Measurements measurements){
        measurementsRepository.save(measurements);
    }
    @Transactional
    public void addMeasurement(Measurements measurements) {
        enrichMeasurement(measurements);
        measurementsRepository.save(measurements);
    }
    public void enrichMeasurement(Measurements measurements) {
        measurements.setSensor(sensorsService.findBySensorName(measurements.getSensor().getSensorName()).get());

        measurements.setMeasurmentsDateTime(LocalDateTime.now());
    }

    public List<Measurements> findAll() {
        return measurementsRepository.findAll();
    }
}
