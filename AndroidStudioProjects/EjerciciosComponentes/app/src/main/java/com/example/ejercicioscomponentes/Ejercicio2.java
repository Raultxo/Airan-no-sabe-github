package com.example.ejercicioscomponentes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio2 extends AppCompatActivity {

    private ListView lista;
    private Web[] datosWeb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio2);

        cargarDatos();

        AdaptadorWeb adaptadorWeb = new AdaptadorWeb(this, datosWeb);

        lista = (ListView) findViewById(R.id.listaWebs);
        View header = getLayoutInflater().inflate(R.layout.cabecera, null);
        lista.addHeaderView(header);

        lista.setAdapter(adaptadorWeb);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String url = ((Web) parent.getItemAtPosition(i)).getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

    }

    private void cargarDatos() {

        ImageView imgGoogle = new ImageView(this);
        imgGoogle.setImageResource(R.drawable.google);

        ImageView imgTwitter = new ImageView(this);
        imgTwitter.setImageResource(R.drawable.twitter);

        ImageView imgCookie = new ImageView(this);
        imgCookie.setImageResource(R.drawable.cookie);

        datosWeb = new Web[]{
                new Web("Twitter", "https://twitter.com/?lang=es", imgTwitter, "Red Social"),
                new Web("Google", "https://google.es", imgGoogle, "Buscador"),
                new Web("Cookie Clicker", "https://orteil.dashnet.org/cookieclicker/", imgCookie, "Juego de Navegador")};
    }

    public void volver(View v) {
        finish();
    }
}