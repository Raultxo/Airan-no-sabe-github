package com.example.ejercicioscomponentes;

public class Pais {

    private String nombre;
    private int poblacion;
    private String atraccionPrincipal;

    public Pais(String nombre, int poblacion, String atraccionPrincipal) {
        this.atraccionPrincipal = atraccionPrincipal;
        this.poblacion = poblacion;
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public String getAtraccionPrincipal() {
        return atraccionPrincipal;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return nombre;
    }

    public String descripcion() {
        String txt = "Pais: " + getNombre();
        txt += "\nCon " + getPoblacion() + " habitantes";
        txt += "\nSu atraccion principal es: " + getAtraccionPrincipal();
        return txt;
    }
}
