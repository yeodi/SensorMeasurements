package com.dansim.Sensor.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "Measurments")
public class Measurements {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "raining")
    @NotNull
    private boolean raining;
    @Column(name = "temperature")
    @Min(value = -100)
    @Max(value = 100)
    @NotNull
    private double temperature;
    @ManyToOne
    @JoinColumn(name = "sensor",referencedColumnName = "sensor_name")
    @NotNull
    private Sensor sensor;
    @Column(name = "measurment_date_time")
    @NotNull
    private LocalDateTime measurmentsDateTime;

    public Measurements(int id, boolean raining, double temperature, Sensor sensor, LocalDateTime measurmentsDateTime) {
        this.id = id;
        this.raining = raining;
        this.temperature = temperature;
        this.sensor = sensor;
        this.measurmentsDateTime = measurmentsDateTime;
    }

    public Measurements() {
    }

    public LocalDateTime getMeasurmentsDateTime() {
        return measurmentsDateTime;
    }

    public void setMeasurmentsDateTime(LocalDateTime measurmentsDateTime) {
        this.measurmentsDateTime = measurmentsDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
