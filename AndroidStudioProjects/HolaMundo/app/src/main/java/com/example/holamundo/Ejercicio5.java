package com.example.holamundo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio5 extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgImagen;
    private Button botonYahoo, botonBing, botonGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio5);

        imgImagen = (ImageView) findViewById(R.id.imagen);
        botonBing = (Button) findViewById(R.id.botonBing);
        botonYahoo = (Button) findViewById(R.id.botonYahoo);
        botonGoogle = (Button) findViewById(R.id.botonGoogle);

        botonYahoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgImagen.setImageResource(R.drawable.logo_yahoo);
            }
        });
    }

    public void cambiarImagen(View v) {
        if(v.equals(botonBing)) {
            imgImagen.setImageResource(R.drawable.logo_bing);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.equals(botonGoogle)) {
            imgImagen.setImageResource(R.drawable.logo_google);
        }
    }
}
