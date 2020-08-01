package com.example.emergencyactivity;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tapadoo.alerter.Alerter;

import java.util.ArrayList;

public class GeofenceActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private GeofencingClient geofencingClient;
    private final static double GEOFENCE_RADIUS_IN_METERS = 500;


    public static final int ADD_TO_TOP = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geofence);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Log.e(">>>>>", "Registering Restart Install receiver");
        registerRestartInstallReceiver();

//        geofencingClient = LocationServices.getGeofencingClient(this);
//
//        ArrayList<Geofence> geofenceList;
//        geofenceList.add(new Geofence.Builder()
//                // Set the request ID of the geofence. This is a string to identify this
//                // geofence.
//                .setRequestId(entry.getKey())
//
//                .setCircularRegion(
//                        entry.getValue().latitude,
//                        entry.getValue().longitude,
//                        Constants.GEOFENCE_RADIUS_IN_METERS
//                )
//                .setExpirationDuration(Constants.GEOFENCE_EXPIRATION_IN_MILLISECONDS)
//                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER |
//                        Geofence.GEOFENCE_TRANSITION_EXIT)
//                .build());
//

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        View alertStatusStrip = LayoutInflater.from(this).inflate(R.layout.activity_period, getRootLayout(), false);
        getRootLayout().addView(alertStatusStrip, ADD_TO_TOP);
    }

//    private int alertStatusStripColor() {
//        return Alerter.create(GeofenceActivity.this) ?
//                getResources().getColor(R.color.design_default_color_primary_dark) : getResources().getColor(R.color.alert_default_error_background);
//    }

    private ViewGroup getRootLayout() {
        return (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //updateAlertStatusStrip();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(activityFinishReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    protected void updateAlertStatusStrip() {
//        findViewById(R.id.defaultAlert).setBackgroundColor(alertStatusStripColor());
//    }
//
//    Alerter getPanicAlert() {
//        return Alerter.create();
//    }


    public void registerRestartInstallReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("org.iilab.pb.RESTART_INSTALL");
        registerReceiver(activityFinishReceiver, intentFilter);
    }

    BroadcastReceiver activityFinishReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("org.iilab.pb.RESTART_INSTALL")) {
                finish();
            }
        }
    };

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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));



    }
//
//    private GeofencingRequest getGeofencingRequest() {
//        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
//        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);
//        builder.addGeofences(geofenceList);
//        return builder.build();
//    }
}