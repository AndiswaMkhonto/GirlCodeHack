package com.example.emergencyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class PeriodActivity extends AppCompatActivity {

       Button postEmergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period);

        postEmergency = (Button) findViewById(R.id.postEmer);

        postEmergency.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent  i = new Intent(PeriodActivity.this, GeofenceActivity.class);
                startActivity(i);

            }
        });




    }
//    public void setupGeoFence ()
//    {
//
//        //setup geofence for Times Square area
//        String requestId = "geof1-timesSquare";
//        double latitude = 40.758896;
//        double longitude = -73.985130;
//        float radius = 0.0001f;
//
//        Geofence geofence = new Geofence.Builder()
//                .setRequestId(requestId)
//                .setCircularRegion(latitude, longitude, radius)
//                .setExpirationDuration(Geofence.NEVER_EXPIRE)
//                .build();
//
//        GeofencingRequest request = new GeofencingRequest.Builder()
//                .addGeofence(geofence)
//                .build();
}