package com.dansim.Sensor.util;

import com.dansim.Sensor.models.Measurements;
import com.dansim.Sensor.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {

    private final SensorsService sensorsService;

    @Autowired
    public MeasurementValidator(SensorsService sensorService) {
        this.sensorsService = sensorService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Measurements.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Measurements measurement = (Measurements) o;

        if (measurement.getSensor() == null) {
            return;
        }

        if (sensorsService.findBySensorName(measurement.getSensor().getSensorName()).isEmpty())
            errors.rejectValue("sensor", "Нет зарегистрированного сенсора с таким именем!");
    }
}
