package com.example.ejerciciosllamadasentreactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Actividad04_2 extends AppCompatActivity {

    private Bundle datos;
    private HashMap<String, Integer> compras;
    private int galletas, galletasBase;
    private TextView galletasClick2, cantGalletas2, cantCursores2, cantAbuelas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad04_2);

        datos = getIntent().getExtras();
        compras = (HashMap<String, Integer>) datos.get("compras");
        galletas = Integer.parseInt(datos.getString("cantidadGalletas"));
        galletasBase = datos.getInt("galletasClick");

        galletasClick2 = (TextView) findViewById(R.id.galletasClick2);
        cantGalletas2 = (TextView) findViewById(R.id.cantGalletas2);
        cantCursores2 = (TextView) findViewById(R.id.cantCursores2);
        cantAbuelas2 = (TextView) findViewById(R.id.cantAbuelas2);

        galletasClick2.setText(String.valueOf(galletasBase));
        cantGalletas2.setText((String.valueOf(galletas)));
        cantCursores2.setText(String.valueOf(compras.get("Cursor")));
        cantAbuelas2.setText(String.valueOf(compras.get("Abuela")));

    }

    public void aumentarCursores(View v) {
        if(galletas >= 10) {
            cantCursores2.setText(String.valueOf(Integer.parseInt(cantCursores2.getText().toString()) + 1));
            galletas -= 10;
            galletasBase += 1;
            galletasClick2.setText(String.valueOf(galletasBase));
        }
    }

    public void aumentarAbuelas(View v) {
        if(galletas >= 50) {
            cantAbuelas2.setText(String.valueOf(Integer.parseInt(cantAbuelas2.getText().toString()) + 1));
            galletas -= 50;
            galletasBase += 5;
            galletasClick2.setText(String.valueOf(galletasBase));
        }
    }

    public void comprasHechas(View v) {
        compras.put("Cursor", Integer.parseInt(cantCursores2.getText().toString()));
        compras.put("Abuela", Integer.parseInt(cantAbuelas2.getText().toString()));
        Intent intent = new Intent(Actividad04_2.this, Actividad04_1.class);
        intent.putExtra("cantidadGalletas", galletas);
        intent.putExtra("compras", compras);
        intent.putExtra("galletasClick", galletasBase);
        startActivity(intent);
        finish();
    }





}
