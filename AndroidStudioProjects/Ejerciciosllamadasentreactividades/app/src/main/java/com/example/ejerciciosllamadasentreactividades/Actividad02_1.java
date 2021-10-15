package com.example.ejerciciosllamadasentreactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Actividad02_1 extends AppCompatActivity {

    private EditText numero1, numero2, resultado;
    private Button botonComprobar;
    private TextView correctas, incorrectas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad02_1);

        numero1 = (EditText) findViewById(R.id.numero1);
        numero2 = (EditText) findViewById(R.id.numero2);
        resultado = (EditText) findViewById(R.id.resultado);
        correctas = (TextView) findViewById(R.id.lblCorrectas);
        incorrectas = (TextView) findViewById(R.id.lblIncorrectas);

        botonComprobar = (Button) findViewById(R.id.botonComprobar);

        generarNumeros();
    }

    public void comprobar(View v) {

        String txtNumero1 = numero1.getText().toString();
        String txtNumero2 = numero2.getText().toString();
        String txtResultado = resultado.getText().toString();

        if(!txtResultado.equals("")) {
            Intent intent = new Intent(Actividad02_1.this, Actividad02_2.class);
            intent.putExtra("numero1", Integer.parseInt(txtNumero1));
            intent.putExtra("numero2", Integer.parseInt(txtNumero2));
            intent.putExtra("resultado", Integer.parseInt(txtResultado));
            startActivityForResult(intent, 1234);
        }
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            correctas.setText(String.valueOf(Integer.parseInt(correctas.getText().toString()) + 1));
        }
        else {
            incorrectas.setText(String.valueOf(Integer.parseInt(incorrectas.getText().toString()) + 1));
        }
        generarNumeros();
    }

    private void generarNumeros() {
        numero1.setText(String.valueOf((int)(Math.random() * 100)));
        numero2.setText(String.valueOf((int)(Math.random() * 100)));
        resultado.setText("");
    }



}
