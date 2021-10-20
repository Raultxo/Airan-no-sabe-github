package com.example.ejercicioscomponentes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void ejercicio1(View v) {
        Intent intent = new Intent(Main.this, Ejercicio1.class);
        startActivity(intent);
    }
    public void ejercicio2(View v) {
        Intent intent = new Intent(Main.this, Ejercicio2.class);
        startActivity(intent);
    }
    public void ejercicio3(View v) {
        Intent intent = new Intent(Main.this, Ejercicio3.class);
        startActivity(intent);
    }

}
