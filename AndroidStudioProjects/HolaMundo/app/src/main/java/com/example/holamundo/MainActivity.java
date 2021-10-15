package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /* EJERCICIO 1 */
    /*
    private EditText txtValor1, txtValor2;
    private TextView lblResult;
    */

    /* EJERCICIO 2 */
    /*
    private EditText txtValor1, txtValor2;
    private TextView lblResult;
    private Button botonSuma, botonResta, botonMulti, botonEntre;
    */

    /* EJERCICIO 3 */
    /*
    private Button botonAzul, botonRojo;
    private LinearLayout layoutPrincipal;
    */

    /* EJERCICIO 4 */
    /*
    private EditText txtNumeroDNI, txtLetraDNI;
    private TextView lblResultado;
    */

    /* EJERCICIO 5 */
    private ImageView imgImagen;
    private Button botonYahoo, botonBing, botonGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* EJERCICIO 1 */
        /*
        txtValor1 = (EditText) findViewById(R.id.valor1);
        txtValor2 = (EditText) findViewById(R.id.valor2);
        lblResult = (TextView) findViewById(R.id.resultado);
        */
        /* EJERCICIO 2 */
        /*
        txtValor1 = (EditText) findViewById(R.id.valor1);
        txtValor2 = (EditText) findViewById(R.id.valor2);
        lblResult = (TextView) findViewById(R.id.resultado);
        botonSuma = (Button) findViewById(R.id.botonSuma);
        botonResta = (Button) findViewById(R.id.botonResta);
        botonMulti = (Button) findViewById(R.id.botonMulti);
        botonEntre = (Button) findViewById(R.id.botonEntre);
        */
        /* EJERCICIO 3 */
        /*
        botonAzul = (Button) findViewById(R.id.botonAzul);
        botonRojo = (Button) findViewById(R.id.botonRojo);
        layoutPrincipal = (LinearLayout) findViewById(R.id.layoutPrincipal);
        */
        /* EJERCICIO 4 */
        /*
        txtNumeroDNI = (EditText) findViewById(R.id.numeroDNI);
        txtLetraDNI = (EditText) findViewById(R.id.letraDNI);
        lblResultado = (TextView) findViewById(R.id.resultado);
        */

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

    /* EJERCICIO 1 */
    /*
    public void sumar(View v) {
        double valor1 = Double.parseDouble(String.valueOf(txtValor1.getText()));
        double valor2 = Double.parseDouble(String.valueOf(txtValor2.getText()));
        lblResult.setText("La suma es: " + (valor1 + valor2));
    }
    */
    /* EJERCICIO 2 */
    /*
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
    */
    /* EJERCICIO 3 */
    /*
    public void cambiarColor(View v) {
        if(v.equals(botonAzul)) {
            layoutPrincipal.setBackgroundColor(Color.CYAN);
        }
        if(v.equals(botonRojo)) {
            layoutPrincipal.setBackgroundColor(Color.RED);
        }
    }
    */
    /* EJERCICIO 4 */
    /*
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
    */
    /* EJERCICIO 5 */
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
