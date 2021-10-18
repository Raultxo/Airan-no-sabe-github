package com.example.ejercicioscomponentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Ejercicio1 extends AppCompatActivity {

    private TextView txtSelecionado;
    private Pais[] paises;
    private ListView lista;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio1);

        cargarDatos();

        txtSelecionado = (TextView) findViewById(R.id.seleccionado);
        lista = (ListView) findViewById(R.id.lista);

        ArrayAdapter<Pais> adaptadorListView = new ArrayAdapter<Pais>(this, android.R.layout.simple_list_item_1, paises);
        lista.setAdapter(adaptadorListView);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pais opcionSeleccionada = (Pais) adapterView.getItemAtPosition(i);
                txtSelecionado.setText(opcionSeleccionada.descripcion());
            }
        });
    }

    private void cargarDatos() {
        paises = new Pais[] {
        new Pais("Francia", 5000000, "Torre Eiffel"),
        new Pais("España", 2000000, "Ayuso"),
        new Pais("Italia", 3000000, "Pizza"),
        new Pais("Andorra", 50000, "Impuestos"),
        new Pais("China", 300000000, "Comunismo")};
    }

    public void volver(View v) {
        finish();
    }
}