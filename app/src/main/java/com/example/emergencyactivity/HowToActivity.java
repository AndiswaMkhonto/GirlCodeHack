package com.example.emergencyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HowToActivity extends AppCompatActivity {

    Button btnPad, btnTampon,btnCondom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to);

                btnPad = (Button) findViewById(R.id.pad);
        btnTampon = (Button) findViewById(R.id.tampon);
        btnCondom = (Button) findViewById(R.id.condom);

        btnPad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.padinformationlayout);
                Intent i = new Intent(HowToActivity.this,PadActivity.class);
                startActivity(i);

            }
        });
        btnTampon.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                setContentView(R.layout.tampooninformationlayout);
                Intent i = new Intent(HowToActivity.this,TamponActivity.class);
                startActivity(i);



            }
        });
        btnCondom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.condominformationlayout);
                Intent i = new Intent(HowToActivity.this,TamponActivity.class);
                startActivity(i);


            }
        });

    }
}