package com.example.emergencyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class StoreLocatorActivity extends AppCompatActivity {

//    private static final String GOOGLE_API_KEY = "AIzaSyDQwI4IWS_AGPesah4sEn32EvMWb_lkcyY";
//    GoogleMap googleMap;
//    EditText placeText;
//    double latitude = 0;
//    double longitude = 0;
//    private int PROXIMITY_RADIUS = 5000;
//
    Button storeLocator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_locator);
        storeLocator = (Button) findViewById(R.id.store);
//
//        storeLocator.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

//                Intent i = new Intent(StoreLocatorActivity.this, GeofenceActivity.class);
//                startActivity(i);
         //   }
       // });


//        setContentView(R.layout.activity_store_locator);
//
//        placeText = (EditText) findViewById(R.id.placeText);
//        Button btnFind = (Button) findViewById(R.id.btnFind);
//        SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap);
//        googleMap = fragment.getMap();
//        googleMap.setMyLocationEnabled(true);
//        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        Criteria criteria = new Criteria();
//        String bestProvider = locationManager.getBestProvider(criteria, true);
//        Location location = locationManager.getLastKnownLocation(bestProvider);
//        if (location != null) {
//            onLocationChanged(location);
//        }
//        locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);
//
//        btnFind.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String type = placeText.getText().toString();
//                StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
//                googlePlacesUrl.append("location=" + latitude + "," + longitude);
//                googlePlacesUrl.append("&radius=" + PROXIMITY_RADIUS);
//                googlePlacesUrl.append("&types=" + type);
//                googlePlacesUrl.append("&sensor=true");
//                googlePlacesUrl.append("&key=" + GOOGLE_API_KEY);
//
//                GooglePlacesReadTask googlePlacesReadTask = new GooglePlacesReadTask();
//                Object[] toPass = new Object[2];
//                toPass[0] = googleMap;
//                toPass[1] = googlePlacesUrl.toString();
//                googlePlacesReadTask.execute(toPass);
//            }
//        });
//    }
//
//    private boolean isGooglePlayServicesAvailable() {
//        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
//        if (ConnectionResult.SUCCESS == status) {
//            return true;
//        } else {
//            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
//            return false;
//        }
//    }
//
//
//    @Override
//    public void onLocationChanged(Location location) {
//        latitude = location.getLatitude();
//        longitude = location.getLongitude();
//        LatLng latLng = new LatLng(latitude, longitude);
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//        googleMap.animateCamera(CameraUpdateFactory.zoomTo(12));
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//        // TODO Auto-generated method stub
//    }
//
//    }

    }
}