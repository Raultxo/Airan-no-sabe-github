package com.example.ejerciciosllamadasentreactividades;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Actividad04_1 extends AppCompatActivity {

    private TextView cantGalletas, cantCursores, cantAbuelas, galletasClick;
    private int galletasBase = 1;
    private HashMap<String, Integer> compras;
    private Bundle datos;
    private AlphaAnimation alpha;
    private ImageView galleta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad04_1);

        datos = getIntent().getExtras();
        cantGalletas = (TextView) findViewById(R.id.cantGalletas);
        cantCursores = (TextView) findViewById(R.id.cantCursores);
        cantAbuelas = (TextView) findViewById(R.id.cantAbuelas);
        galletasClick = (TextView) findViewById(R.id.galletasClick);
        galleta = (ImageView) findViewById(R.id.galleta);

        if(datos == null) {
            galletasBase = 1;
            galletasClick.setText(String.valueOf(galletasBase));
            compras = new HashMap<String, Integer>();
            compras.put("Cursor", 0);
            compras.put("Abuela", 0);
            cantGalletas.setText("0");
        }
        else {
            galletasBase = datos.getInt("galletasClick");
            galletasClick.setText(String.valueOf(galletasBase));
            cantGalletas.setText(String.valueOf(datos.getInt("cantidadGalletas")));
            compras = (HashMap<String, Integer>) datos.get("compras");
            cantCursores.setText(String.valueOf(compras.get("Cursor")));
            cantAbuelas.setText(String.valueOf(compras.get("Abuela")));

        }
    }

    public void clickGalleta(View v) {
        alpha = new AlphaAnimation(0, 100);
        alpha.setDuration(500);
        galleta.startAnimation(alpha);
        cantGalletas.setText(String.valueOf(Integer.parseInt(cantGalletas.getText().toString()) + galletasBase));
    }

    public void comprar(View v) {
        Intent intent = new Intent(Actividad04_1.this, Actividad04_2.class);
        intent.putExtra("cantidadGalletas", String.valueOf(Integer.parseInt(cantGalletas.getText().toString())));
        intent.putExtra("compras", compras);
        intent.putExtra("galletasClick", galletasBase);
        startActivity(intent);
        finish();
    }

}
