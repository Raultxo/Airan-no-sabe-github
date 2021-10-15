package com.example.holamundo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio3 extends AppCompatActivity {

    private Button botonAzul, botonRojo;
    private LinearLayout layoutPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio3);


        botonAzul = (Button) findViewById(R.id.botonAzul);
        botonRojo = (Button) findViewById(R.id.botonRojo);
        layoutPrincipal = (LinearLayout) findViewById(R.id.layoutPrincipal);

    }


    public void cambiarColor(View v) {
        if(v.equals(botonAzul)) {
            layoutPrincipal.setBackgroundColor(Color.CYAN);
        }
        if(v.equals(botonRojo)) {
            layoutPrincipal.setBackgroundColor(Color.RED);
        }
    }

}
