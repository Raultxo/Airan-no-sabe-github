package com.example.ejerciciosllamadasentreactividades;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Actividad03_2 extends AppCompatActivity {

    private TextView lblNombreApellidos, lblSexo, lblAficiones, lblDatosCorrectos;
    private Bundle extras;
    private boolean[] datosCorrectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad03_2);

        datosCorrectos = new boolean[2];

        lblNombreApellidos = (TextView) findViewById(R.id.lblNombreApellidos);
        lblSexo = (TextView) findViewById(R.id.lblSexo);
        lblAficiones = (TextView) findViewById(R.id.lblAficiones);
        lblDatosCorrectos = (TextView) findViewById(R.id.lblDatosCorrectos);

        extras = getIntent().getExtras();

        String strNombre = "";
        if(extras.getString("nombre").equals("") && extras.getString("apellidos").equals("")) {
            strNombre = "Nombre desconocido";
            datosCorrectos[0] = false;
        }
        else {
            strNombre = extras.getString("nombre") + " " + extras.getString("apellidos");
            datosCorrectos[0] = true;
        }

        lblNombreApellidos.setText(strNombre);

        if(extras.getString("sexo").equals("desconocido")) {
            datosCorrectos[1] = false;
        }
        else {
            datosCorrectos[1] = true;
        }
        lblSexo.setText("Sexo: " + extras.getString("sexo"));

        ArrayList<String> aficiones = extras.getStringArrayList("aficiones");
        String str;
        if(aficiones.size() == 0) {
            str = "Sin aficiones";
        }
        else {
            str = "Aficiones: ";
            for(String aficion : aficiones) {
                str += aficion + ", ";
            }
            str = str.substring(0, str.length() - 2);
        }

        lblAficiones.setText(str);

        String str2 = "";
        if(!datosCorrectos[0]) {
            str2 += "Tienes que introducir tu nombre y apellidos\n";
        }

        if(!datosCorrectos[1]) {
            str2 += "Tienes que elegir un sexo";
        }

        lblDatosCorrectos.setText(str2);
        if(str2.equals("")) {
            lblDatosCorrectos.setTextColor(Color.GREEN);
            lblDatosCorrectos.setText("DATOS CORRECTOS");
        }


    }

    public void volver(View v) {
        finish();
    }



}
