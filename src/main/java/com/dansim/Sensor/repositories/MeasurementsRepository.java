package com.dansim.Sensor.repositories;

import com.dansim.Sensor.models.Measurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurements,Integer> {
}
