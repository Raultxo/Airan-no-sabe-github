package com.example.ejerciciosllamadasentreactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Actividad01_1 extends AppCompatActivity {

    private EditText txtNombre, txtApellidos;
    private TextView lblCondiciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad01_1);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellidos = (EditText) findViewById(R.id.txtApellidos);
        lblCondiciones = (TextView) findViewById(R.id.lblCondiciones);
    }

    public void verificar(View v) {

        String nombre = txtNombre.getText().toString();
        String apellidos = txtApellidos.getText().toString();

        Intent intent = new Intent(Actividad01_1.this, Actividad01_2.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellidos", apellidos);
        startActivityForResult(intent, 123);

    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK) {
            lblCondiciones.setText("Aceptas condiciones: ACEPTADO");
        }
        else {
            lblCondiciones.setText("Aceptas condiciones: RECHAZADO");
        }
    }

    public void volver(View v) {
        finish();
    }



}
