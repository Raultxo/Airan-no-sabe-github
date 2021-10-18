package com.example.ejercicioscomponentes;

import android.widget.ImageView;

public class Web {

    private String nombre;
    private String url;
    private ImageView img;
    private String identificativo;

    public Web(String nombre, String url, ImageView img, String identificativo) {
        this.nombre = nombre;
        this.url = url;
        this.img = img;
        this.identificativo = identificativo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public ImageView getImg() {
        return img;
    }

    public String getIdentificativo() {
        return identificativo;
    }
}
