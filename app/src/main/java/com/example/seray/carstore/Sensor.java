package com.example.seray.carstore;

/**
 * Created by Seray on 5/19/2016.
 */
public abstract class Sensor {
    protected double value;
    protected String unit;

    public Sensor() {}

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
