package com.example.ejerciciosllamadasentreactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Actividad02_2 extends AppCompatActivity {

    private Bundle extras;
    private TextView lblResultado;
    private boolean correcto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad02_2);

        lblResultado = (TextView) findViewById(R.id.lblResutlado);
        extras = getIntent().getExtras();

        if(extras.getInt("numero1") + extras.getInt("numero2") == extras.getInt("resultado")) {
            lblResultado.setText("CORRECTA");
            correcto = true;
        }
        else {
            lblResultado.setText("INCORRECTA");
            correcto = false;
        }
    }

    public void devolver(View v) {
        Intent intent = new Intent();
        if(correcto) {
            setResult(RESULT_OK, intent);
        }
        else {
            setResult(RESULT_CANCELED, intent);
        }
        finish();
    }



}
