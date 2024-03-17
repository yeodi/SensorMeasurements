package com.dansim.Sensor.repositories;

import com.dansim.Sensor.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorsRepository extends JpaRepository<Sensor,Integer> {
    public Optional<Sensor> findBySensorName(String sensorName);
}
