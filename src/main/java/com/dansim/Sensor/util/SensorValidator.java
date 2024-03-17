package com.dansim.Sensor.util;

import com.dansim.Sensor.models.Sensor;
import com.dansim.Sensor.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class SensorValidator implements Validator {
    private final SensorsService sensorsService;
    @Autowired
    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;

        if (sensorsService.findBySensorName(sensor.getSensorName()).isPresent()){
            errors.rejectValue("sensorName","","This name is already taken");
        }

    }
}
