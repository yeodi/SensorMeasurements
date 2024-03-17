package com.dansim.Sensor.services;


import com.dansim.Sensor.models.Sensor;
import com.dansim.Sensor.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorsService  {
    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }
    @Transactional
    public void save(Sensor sensor){
        sensorsRepository.save(sensor);

    }
    public Sensor findById(int id) {
        Optional<Sensor> foundSensor = sensorsRepository.findById(id);
        return foundSensor.orElse(null);
    }
    public Optional<Sensor> findBySensorName(String sensorName) {
        return sensorsRepository.findBySensorName(sensorName);

    }

}
