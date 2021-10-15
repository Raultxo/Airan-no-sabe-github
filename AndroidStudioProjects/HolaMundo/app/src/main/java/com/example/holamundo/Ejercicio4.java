package com.example.holamundo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio4 extends AppCompatActivity {

    private EditText txtNumeroDNI, txtLetraDNI;
    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio4);


        txtNumeroDNI = (EditText) findViewById(R.id.numeroDNI);
        txtLetraDNI = (EditText) findViewById(R.id.letraDNI);
        lblResultado = (TextView) findViewById(R.id.resultado);

    }


    public void validarDNI(View v) {

        int n = Integer.parseInt(String.valueOf(txtNumeroDNI.getText()));
        String palabra = "TRWAGMYFPDXBNJZSQVHLCKE";
        String letra = "" + palabra.charAt(n % 23);

        lblResultado.setText(txtLetraDNI.getText());
        if(letra.equals(String.valueOf(txtLetraDNI.getText()).toUpperCase())) {
            lblResultado.setText("DNI CORRECTO");
            lblResultado.setBackgroundColor(Color.GREEN);
        }
        else {
            lblResultado.setText("DNI INCORRECTO");
            lblResultado.setBackgroundColor(Color.RED);
        }
    }

}
