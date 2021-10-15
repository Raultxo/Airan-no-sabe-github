package com.example.ejerciciosllamadasentreactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Actividad01_2 extends AppCompatActivity {

    private Bundle extras;
    private TextView lblNorte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad01_2);

        lblNorte = (TextView) findViewById(R.id.lblNorte);

        extras = getIntent().getExtras();

        String str = "Hola " + extras.getString("nombre") + " " + extras.getString("apellidos");
        str += " ¿Aceptas las condiciones?";

        lblNorte.setText(str);
    }

    public void aceptar(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    public void rechazar(View v) {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }


}
