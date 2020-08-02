package com.example.emergencyactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.tapadoo.alerter.Alerter;

public class MainActivity extends AppCompatActivity {

    Button defaul,chat_btn,howto_btn;
    Button btnPad, btnTampon,btnCondom;
//    GeofenceActivity g = new GeofenceActivity();
//
//
//    private PendingIntent getGeofencePendingIntent() {
//        // Reuse the PendingIntent if we already have it.
//        if (geofencePendingIntent() != null) {
//            return geofencePendingIntent;
//        }
//        Intent intent = new Intent(this, GeofenceBroadcastReceiver.class);
//        // We use FLAG_UPDATE_CURRENT so that we get the same pending intent back when
//        // calling addGeofences() and removeGeofences().
//        geofencePendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.
//                FLAG_UPDATE_CURRENT);
//        return geofencePendingIntent;
//
//
//        geofencingClient.addGeofences(getGeofencingRequest(), getGeofencePendingIntent())
//                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        // Geofences added
//                        // ...
//                    }
//                })
//                .addOnFailureListener(this, new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        // Failed to add geofences
//                        // ...
//                    }
//                });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      defaul = (Button) findViewById(R.id.defaultAlert);

       defaul.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Alerter.create(MainActivity.this)
                        .setTitle("Default Alerter")
                        .setText("This is alerter")
                        //.setBackgroundColor(R.color.colorPrimary)
                        .show();
                defaul.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, Emergencies.class);
                        startActivity(intent);
                    }
                });

            }
        });


       chat_btn = (Button) findViewById(R.id.chat);

       chat_btn.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View view) {
               Intent i = new Intent(MainActivity.this, LetsChatActivity.class);
               startActivity(i);

           }
       });

       howto_btn = (Button) findViewById(R.id.how);

       howto_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               setContentView(R.layout.activity_how_to);
           }
       });


//        btnPad = (Button) findViewById(R.id.pad);
//        btnTampon = (Button) findViewById(R.id.tampon);
//        btnCondom = (Button) findViewById(R.id.condom);
//
//        btnPad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //setContentView(R.layout.padinformationlayout);
//                Intent i = new Intent(MainActivity.this,PadActivity.class);
//                startActivity(i);
//
//            }
//        });
//        btnTampon.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                //setContentView(R.layout.tampooninformationlayout);
//                Intent i = new Intent(MainActivity.this,TamponActivity.class);
//                startActivity(i);
//
//
//
//            }
//        });
//        btnCondom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //setContentView(R.layout.condominformationlayout);
//                Intent i = new Intent(MainActivity.this,TamponActivity.class);
//                startActivity(i);
//
//
//            }
//        });
    }


}