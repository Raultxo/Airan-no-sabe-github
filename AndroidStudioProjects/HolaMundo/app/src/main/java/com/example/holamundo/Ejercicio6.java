package com.example.holamundo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio6 extends AppCompatActivity {

    private ToggleButton botonCamara2, botonLuz2;
    private Switch switchCamara1, switchLuz1;
    private ImageView camara1, camara2, luz1, luz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio6);

        botonCamara2 = (ToggleButton) findViewById(R.id.botonCamara2);
        botonLuz2 = (ToggleButton) findViewById(R.id.botonLuz2);
        switchCamara1 = (Switch) findViewById(R.id.switchCamara1);
        switchLuz1 = (Switch) findViewById(R.id.switchLuz1);
        camara1 = (ImageView) findViewById(R.id.camara1);
        camara2 = (ImageView) findViewById(R.id.camara2);
        luz1 = (ImageView) findViewById(R.id.luz1);
        luz2 = (ImageView) findViewById(R.id.luz2);

    }

    public void camara(View v) {
        if(v.equals(botonCamara2)) {
            if(botonCamara2.isChecked()) {
                camara2.setVisibility(View.VISIBLE);
            }
            else {
                camara2.setVisibility(View.INVISIBLE);
            }
        }
        else {
            if(switchCamara1.isChecked()) {
                camara1.setVisibility(View.VISIBLE);
            }
            else {
                camara1.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void luz(View v) {
        if(v.equals(botonLuz2)) {
            if(botonLuz2.isChecked()) {
                luz2.setImageResource(R.drawable.luz_encendida);
            }
            else {
                luz2.setImageResource(R.drawable.luz_apagada);
            }
        }
        else {
            if(switchLuz1.isChecked()) {
                luz1.setImageResource(R.drawable.luz_encendida);
            }
            else {
                luz1.setImageResource(R.drawable.luz_apagada);
            }
        }
    }
}
