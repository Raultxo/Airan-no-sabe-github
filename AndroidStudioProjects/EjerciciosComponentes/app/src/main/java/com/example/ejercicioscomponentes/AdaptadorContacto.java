package com.example.ejercicioscomponentes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorContacto extends ArrayAdapter<String[]> {

    private String[][] datos;

    public AdaptadorContacto(@NonNull Context context, String[][] datos) {
        super(context, R.layout.contacto, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.contacto, null);

        TextView nombre = (TextView) item.findViewById(R.id.nombreContacto);
        nombre.setText(datos[position][0]);

        TextView url = (TextView) item.findViewById(R.id.numero);
        url.setText(datos[position][1]);

        return item;
    }

}
