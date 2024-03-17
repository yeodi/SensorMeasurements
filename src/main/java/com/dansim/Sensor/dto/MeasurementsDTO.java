package com.dansim.Sensor.dto;

import com.dansim.Sensor.models.Sensor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class MeasurementsDTO {
        private boolean raining;
        @Min(value = -100)
        @Max(value = 100)
        private double temperature;

        private Sensor sensor;

        public MeasurementsDTO(boolean raining, double temperature, Sensor sensor) {

            this.raining = raining;
            this.temperature = temperature;
            this.sensor = sensor;
        }

        public MeasurementsDTO() {
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
