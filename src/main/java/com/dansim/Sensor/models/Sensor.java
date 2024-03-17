package com.dansim.Sensor.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Sensor")
public class Sensor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sensor_name")
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2,max = 30,message = "Name should be between 2 and 30 characters")
    @NotNull
    private String sensorName;
    @OneToMany(mappedBy = "sensor")
    private List<Measurements> measurments;

    public Sensor(int id, String sensorName) {
        this.id = id;
        this.sensorName = sensorName;
    }

    public Sensor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
}
