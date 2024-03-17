package com.dansim.Sensor.dto;

import com.dansim.Sensor.models.Measurements;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class SensorDTO {
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2,max = 30,message = "Name should be between 2 and 30 characters")
    private String sensorName;

    private List<Measurements> measurments;

    public SensorDTO(String sensorName, List<Measurements> measurments) {
        this.sensorName = sensorName;
        this.measurments = measurments;
    }

    public SensorDTO(){

    }
    public List<Measurements> getMeasurments() {
        return measurments;
    }

    public void setMeasurments(List<Measurements> measurments) {
        this.measurments = measurments;
    }
    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
}
