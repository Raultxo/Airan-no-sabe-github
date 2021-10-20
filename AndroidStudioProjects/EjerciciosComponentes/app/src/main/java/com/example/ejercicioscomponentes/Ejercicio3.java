package com.example.ejercicioscomponentes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio3 extends AppCompatActivity {

    private String[] datos;
    private GridView gridNums;
    private EditText txtNumero;
    private String[][] datosContacto;
    private ListView listaContactos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio3);

        cargarDatos();

        AdaptadorContacto adaptadorContacto = new AdaptadorContacto(this, datosContacto);
        listaContactos = (ListView) findViewById(R.id.listaFavoritos);
        listaContactos.setAdapter(adaptadorContacto);
        gridNums = (GridView) findViewById(R.id.grid);
        txtNumero = (EditText) findViewById(R.id.txtNumero);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
        gridNums.setAdapter(adaptador);

        gridNums.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,android.view.View v, int position, long id) {
                txtNumero.setText(txtNumero.getText().toString() + parent.getItemAtPosition(position));
            }
        });

        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String numero = ((String[]) parent.getItemAtPosition(i))[1];
                txtNumero.setText(numero);
            }
        });
    }

    private void cargarDatos() {
        datos = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
        datosContacto = new String[][] {{"EMERGENCIAS", "112"}, {"EMERGENCIAS EEUU", "911"}};
    }

    public void llamar(View v) {
        if(!(txtNumero.getText().toString().length() < 9) ||
                txtNumero.getText().toString().equals("112") ||
                txtNumero.getText().toString().equals("911")
        ) {
            Intent intent= new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + txtNumero.getText().toString()));
            startActivity(intent);
        }
    }

    public void borrar(View v) {
        txtNumero.setText("");
    }

    public void volver(View v) {
        finish();
    }
}