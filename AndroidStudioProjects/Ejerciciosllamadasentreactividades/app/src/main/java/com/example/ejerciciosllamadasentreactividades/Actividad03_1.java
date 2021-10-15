package com.example.ejerciciosllamadasentreactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Actividad03_1 extends AppCompatActivity {

    private EditText textNombre, textApellidos;
    private RadioButton radioMasc, radioFem;
    private CheckBox[] checks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad03_1);

        textNombre = (EditText) findViewById(R.id.textNombre);
        textApellidos = (EditText) findViewById(R.id.textApellidos);
        radioFem = (RadioButton) findViewById(R.id.radioFemenino);
        radioMasc = (RadioButton) findViewById(R.id.radioMasculino);
        radioMasc.setSelected(true);

        checks = new CheckBox[4];
        checks[0] = (CheckBox) findViewById(R.id.checkDeportes);
        checks[1] = (CheckBox) findViewById(R.id.checkLectura);
        checks[2] = (CheckBox) findViewById(R.id.checkViajar);
        checks[3] = (CheckBox) findViewById(R.id.checkMusica);

    }

    public void enviar(View v) {

        Intent intent = new Intent(Actividad03_1.this, Actividad03_2.class);

        String nombre = textNombre.getText().toString();
        String apellidos = textApellidos.getText().toString();
        ArrayList<String> aficiones = new ArrayList<String>();
        for(int i = 0; i < checks.length; i++) {
            if(checks[i].isChecked()) {
                aficiones.add(checks[i].getText().toString());
            }
        }
        String sexo;
        if(radioMasc.isChecked()) {
            sexo = radioMasc.getText().toString();
        }
        else {
            if(radioFem.isChecked()) {
                sexo = radioFem.getText().toString();
            }
            else {
                sexo = "desconocido";
            }

        }

        intent.putExtra("nombre", nombre);
        intent.putExtra("apellidos", apellidos);
        intent.putExtra("aficiones", aficiones);
        intent.putExtra("sexo", sexo);

        startActivity(intent);

    }


}
