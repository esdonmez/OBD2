package com.example.seray.carstore;

import android.graphics.Color;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Timer;
import java.util.TimerTask;

public class GPS extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Timer timer = new Timer();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng department;

        final PolylineOptions options = new PolylineOptions().width(5).color(Color.MAGENTA).geodesic(true);
        department = new LatLng(38.368965, 27.209613);
        mMap.addMarker(new MarkerOptions().position(department).title("Me"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(department, 13));

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        LocationCar loc = (LocationCar) MainActivity.vehicle.getSensor()[7];

                        LatLng location = new LatLng(loc.getLongitude(), loc.getLatitude());
                        mMap.addMarker(new MarkerOptions().position(location));
                        options.add(location);
                        Polyline line = mMap.addPolyline(options);
                    }
                });
            }
        }, 1000, 1000);
    }

    private void drawMarker(Location location)
    {
        mMap.clear();
        LatLng currentPosition = new LatLng(location.getLatitude(), location.getLongitude());
        mMap.addMarker(new MarkerOptions().position(currentPosition).snippet("Lat : " + location.getLatitude() + "Lng : " + location.getLongitude()).title("ME"));
    }
}
