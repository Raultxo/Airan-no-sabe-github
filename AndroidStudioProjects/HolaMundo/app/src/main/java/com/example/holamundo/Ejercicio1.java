package com.example.holamundo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio1 extends AppCompatActivity {

    private EditText txtValor1, txtValor2;
    private TextView lblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio1);
        txtValor1 = (EditText) findViewById(R.id.valor1);
        txtValor2 = (EditText) findViewById(R.id.valor2);
        lblResult = (TextView) findViewById(R.id.resultado);

    }

    public void sumar(View v) {
        double valor1 = Double.parseDouble(String.valueOf(txtValor1.getText()));
        double valor2 = Double.parseDouble(String.valueOf(txtValor2.getText()));
        lblResult.setText("La suma es: " + (valor1 + valor2));
    }

}
