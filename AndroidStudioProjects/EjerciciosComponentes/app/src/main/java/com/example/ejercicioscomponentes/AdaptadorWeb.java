package com.example.ejercicioscomponentes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorWeb extends ArrayAdapter<Web> {

    private Web[] datos;

    public AdaptadorWeb(@NonNull Context context, Web[] datos) {
        super(context, R.layout.web, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.web, null);

        TextView nombre = (TextView) item.findViewById(R.id.nombre);
        nombre.setText(datos[position].getNombre());

        TextView url = (TextView) item.findViewById(R.id.url);
        url.setText(datos[position].getUrl());

        ImageView img = (ImageView) item.findViewById(R.id.imagen);
        img.setImageDrawable(datos[position].getImg().getDrawable());

        TextView identificativo = (TextView) item.findViewById(R.id.identificativo);
        identificativo.setText(datos[position].getIdentificativo());

        return item;
    }

}
