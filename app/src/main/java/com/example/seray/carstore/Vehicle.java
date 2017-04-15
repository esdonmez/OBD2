package com.example.seray.carstore;

/**
 * Created by Seray on 5/19/2016.
 */
public class Vehicle {
    private String type;
    private String model;
    private String year;
    private Sensor sensor[];
    public double maxFuelAmount;
    public double maxExhaust;
    public double maxEngineOilTemperature;
    public double maxEngineSpeed;
    public double maxEngineTemperature;
    public double maxSpeed;

    public Vehicle() {
        type = null;
        model = null;
        year = null;
        sensor = new Sensor[8];
        maxFuelAmount = 60;
        maxExhaust = 10;
        maxEngineOilTemperature = 100;
        maxEngineTemperature = 100;
        maxEngineSpeed = 6000;
        maxSpeed = 260;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String model) {
        this.year = year;
    }

    public Sensor[] getSensor() {
        return sensor;
    }

    public void setSensor(Sensor[] sensor) {
        this.sensor = sensor;
    }
}
