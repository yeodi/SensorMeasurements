package com.dansim.Sensor.controllers;

import com.dansim.Sensor.dto.MeasurementsDTO;
import com.dansim.Sensor.dto.MeasurementsResponse;
import com.dansim.Sensor.models.Measurements;
import com.dansim.Sensor.services.MeasurementsService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

    private final MeasurementsService measurementsService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementsController( MeasurementsService measurementsService, ModelMapper modelMapper) {
        this.measurementsService = measurementsService;
        this.modelMapper = modelMapper;
    }
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementsDTO measurementsDTO){
        measurementsService.addMeasurement(convertToMeasurements(measurementsDTO));
        return ResponseEntity.ok(HttpStatus.OK);

    }
    @GetMapping()
    public MeasurementsResponse getMeasurements() {
        return new MeasurementsResponse(measurementsService.findAll().stream().map(this::convertToMeasurementDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/rainyDaysCount")
    public Long getRainyDaysCount() {
        return measurementsService.findAll().stream().filter(Measurements::isRaining).count();
    }

    private Measurements convertToMeasurements(MeasurementsDTO measurementsDTO){
        return modelMapper.map(measurementsDTO, Measurements.class);
    }
    private MeasurementsDTO convertToMeasurementDTO(Measurements measurement) {
        return modelMapper.map(measurement, MeasurementsDTO.class);
    }
}
