package com.abhishekvenunathan.locationdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    String provider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
        provider=locationManager.getBestProvider(new Criteria(),false);

        @SuppressLint("MissingPermission") Location location=locationManager.getLastKnownLocation(provider);

        if(location!=null){
            Log.i("Location:", "Done");
        }else{
            Log.i("Location:","No");
        }
    }

    @SuppressLint("MissingPermission")
    @Override
    protected void onResume() {
        super.onResume();

        locationManager.requestLocationUpdates(provider,1000,1,this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {

        Double lat = location.getLatitude();
        Double lng = location.getLongitude();

        Log.i("Lat:",lat.toString());
        Log.i("Lat:",lng.toString());

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
