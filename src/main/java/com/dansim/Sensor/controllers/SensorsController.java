package com.dansim.Sensor.controllers;

import com.dansim.Sensor.dto.SensorDTO;
import com.dansim.Sensor.models.Sensor;
import com.dansim.Sensor.services.SensorsService;
import com.dansim.Sensor.util.SensorValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorsController {
    private final SensorsService sensorsService;
    private final SensorValidator sensorValidator;
    private final ModelMapper mapper;

    @Autowired
    public SensorsController(SensorsService sensorsService, SensorValidator sensorValidator, ModelMapper mapper) {
        this.sensorsService = sensorsService;
        this.sensorValidator = sensorValidator;
        this.mapper = mapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult){
        Sensor sensor = convertToSensor(sensorDTO);
        sensorValidator.validate(sensor,bindingResult);
        sensorsService.save(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO){
        return mapper.map(sensorDTO, Sensor.class);
    }
}
