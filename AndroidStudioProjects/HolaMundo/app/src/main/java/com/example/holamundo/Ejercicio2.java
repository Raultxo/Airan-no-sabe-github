package com.example.holamundo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio2 extends AppCompatActivity {

    private EditText txtValor1, txtValor2;
    private TextView lblResult;
    private Button botonSuma, botonResta, botonMulti, botonEntre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio2);


        txtValor1 = (EditText) findViewById(R.id.valor1);
        txtValor2 = (EditText) findViewById(R.id.valor2);
        lblResult = (TextView) findViewById(R.id.resultado);
        botonSuma = (Button) findViewById(R.id.botonSuma);
        botonResta = (Button) findViewById(R.id.botonResta);
        botonMulti = (Button) findViewById(R.id.botonMulti);
        botonEntre = (Button) findViewById(R.id.botonEntre);

    }

    public void operacion(View v) {
        if (v.equals(botonSuma)) {
            double valor1 = Double.parseDouble(String.valueOf(txtValor1.getText()));
            double valor2 = Double.parseDouble(String.valueOf(txtValor2.getText()));
            lblResult.setText("RESULTADO: " + (valor1 + valor2));
        }
        if (v.equals(botonResta)) {
            double valor1 = Double.parseDouble(String.valueOf(txtValor1.getText()));
            double valor2 = Double.parseDouble(String.valueOf(txtValor2.getText()));
            lblResult.setText("RESUTLADO: " + (valor1 - valor2));
        }
        if (v.equals(botonMulti)) {
            double valor1 = Double.parseDouble(String.valueOf(txtValor1.getText()));
            double valor2 = Double.parseDouble(String.valueOf(txtValor2.getText()));
            lblResult.setText("RESULTADO: " + (valor1 * valor2));
        }
        if (v.equals(botonEntre)) {
            double valor1 = Double.parseDouble(String.valueOf(txtValor1.getText()));
            double valor2 = Double.parseDouble(String.valueOf(txtValor2.getText()));
            lblResult.setText("RESULTADO: " + (valor1 / valor2));
        }
    }
}
