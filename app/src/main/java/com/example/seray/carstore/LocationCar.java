package com.example.seray.carstore;

/**
 * Created by Seray on 5/20/2016.
 */
public class LocationCar extends Sensor{

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    private double longitude;
    private double latitude;

    public LocationCar(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }


}
